package com.github.greghynds.approvals.formatter

import java.lang.reflect.Modifier
import java.util.*

internal object ClassFormatter : OutputFormatter {

    override fun matches(input: Any): Boolean {
        return !(PrimitiveFormatter.matches(input) && KotlinObjectFormatter.matches(input))
    }

    override fun format(input: Any): String {
        val output = LinkedList<String>()
        var clazz: Class<in Any>? = input.javaClass

        while (clazz != null) {
            clazz.declaredFields
                .filterNot { field -> Modifier.isStatic(field.modifiers) }
                .forEach { field ->
                    field.isAccessible = true
                    val value = field.get(input)
                    val namePrefix = "${field.name}="
                    val valueAsString = when {
                        KotlinObjectFormatter.matches(value) -> KotlinObjectFormatter.format(value)
                        else -> value?.toString()?.trim()
                    }

                    output += namePrefix + valueAsString
                }

            clazz = clazz.superclass
        }

        return "${input.javaClass.simpleName}(${output.joinToString(", ")})"
    }
}
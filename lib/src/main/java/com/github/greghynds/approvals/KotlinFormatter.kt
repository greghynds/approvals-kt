package com.github.greghynds.approvals

import com.github.writethemfirst.approvals.utils.OutputFormatter
import java.lang.reflect.Modifier
import java.util.*

class KotlinFormatter : OutputFormatter {

    override fun format(obj: Any): String {
        val output = LinkedList<String>()
        var clazz: Class<in Any>? = obj.javaClass

        if (clazz != null && (clazz.isPrimitive || obj.isBoxType())) {
            return obj.toString()
        }

        while (clazz != null) {
            clazz.declaredFields
                .filterNot { Modifier.isStatic(it.modifiers) }
                .forEach { prop ->
                    prop.isAccessible = true
                    val value = prop.get(obj)
                    val namePrefix = "${prop.name}="
                    val valueAsString = when {
                        value.javaClass.isKotlinObject() -> value.javaClass.simpleName
                        else -> value?.toString()?.trim()
                    }

                    output += namePrefix + valueAsString

                }
            clazz = clazz.superclass
        }

        return "${obj.javaClass.simpleName}=[${output.joinToString(", ")}]"
    }

    private fun Class<*>.isKotlinObject(): Boolean {
        return kotlin.objectInstance != null
    }

    private fun Any.isBoxType(): Boolean {
        return this is String ||
                this is Boolean ||
                this is Int ||
                this is Char ||
                this is Byte ||
                this is Short ||
                this is Double ||
                this is Long ||
                this is Float
    }
}
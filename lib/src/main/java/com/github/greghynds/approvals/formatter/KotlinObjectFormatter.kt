package com.github.greghynds.approvals.formatter

internal object KotlinObjectFormatter : OutputFormatter {

    override fun matches(input: Any): Boolean {
        return input.javaClass.isKotlinObject()
    }

    override fun format(input: Any): String {
        return input.javaClass.simpleName
    }

    private fun Class<*>.isKotlinObject(): Boolean {
        return kotlin.objectInstance != null
    }
}
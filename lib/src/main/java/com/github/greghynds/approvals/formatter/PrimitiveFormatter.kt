package com.github.greghynds.approvals.formatter

internal object PrimitiveFormatter : OutputFormatter {

    override fun matches(input: Any): Boolean {
        return input.javaClass.isPrimitive || input.isBoxType()
    }

    override fun format(input: Any): String {
        return input.toString()
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
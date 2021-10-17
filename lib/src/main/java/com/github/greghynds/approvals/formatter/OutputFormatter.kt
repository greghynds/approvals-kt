package com.github.greghynds.approvals.formatter

interface OutputFormatter {
    fun matches(input: Any): Boolean
    fun format(input: Any): String
}
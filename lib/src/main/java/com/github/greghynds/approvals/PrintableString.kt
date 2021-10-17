package com.github.greghynds.approvals

import com.github.greghynds.approvals.formatter.ClassFormatter
import com.github.greghynds.approvals.formatter.KotlinObjectFormatter
import com.github.greghynds.approvals.formatter.OutputFormatter
import com.github.greghynds.approvals.formatter.PrimitiveFormatter

object PrintableString {

    fun from(input: Any): String {
        return formatterFor(input).format(input)
    }

    private fun formatterFor(input: Any): OutputFormatter {
        return when {
            PrimitiveFormatter.matches(input) -> PrimitiveFormatter
            KotlinObjectFormatter.matches(input) -> KotlinObjectFormatter
            else -> ClassFormatter
        }
    }
}
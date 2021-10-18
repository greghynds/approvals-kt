package com.github.greghynds.approvals

import com.github.greghynds.approvals.formatter.ClassFormatter
import com.github.greghynds.approvals.formatter.KotlinObjectFormatter
import com.github.greghynds.approvals.formatter.PrimitiveFormatter
import org.approvaltests.strings.Printable

fun <T : Any> T.toPrintableString(): String {
    return when {
        PrimitiveFormatter.matches(this) -> PrimitiveFormatter
        KotlinObjectFormatter.matches(this) -> KotlinObjectFormatter
        else -> ClassFormatter
    }.format(this)
}

fun <T : Any> T.toPrintable(): Printable<T> {
    return object : Printable<T>(this, { obj -> obj.toPrintableString() }) {}
}
package com.github.greghynds.approvals

import org.approvaltests.strings.Printable
import org.lambda.functions.Function1

class KotlinPrintable<T : Any>(value: T) : Printable<T>(
    value,
    Function1 { obj -> PrintableString.from(obj) }
)

fun <T : Any> T.toPrintable(): Printable<T> {
    return KotlinPrintable(this)
}
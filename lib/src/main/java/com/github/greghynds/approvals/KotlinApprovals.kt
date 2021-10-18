package com.github.greghynds.approvals

import org.approvaltests.Approvals

object KotlinApprovals {

    fun verify(output: Any) {
        Approvals.verify(output.toPrintable())
    }
}
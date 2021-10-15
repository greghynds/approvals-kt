package com.github.greghynds.approvals

import com.github.writethemfirst.approvals.approvers.Approver


fun verify(output: Any) {
    Approver().verify(output, KotlinFormatter())
}
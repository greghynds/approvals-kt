package com.github.greghynds

import com.github.greghynds.approvals.KotlinApprovals.verify
import org.junit.Test


class ExampleTest {

    @Test
    fun `two plus two equals four`() {
        val result = 2 + 2

        verify(result)
    }
}
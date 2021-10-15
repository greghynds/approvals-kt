package com.github.greghynds.approvals

import com.github.greghynds.approvals.KotlinFormatterTest.Sealed.AnObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class KotlinFormatterTest {

    @Test
    fun `formats primitive fields`() {
        val data = DummyData(123, 456L, "lorem ipsum", 5.0F, 10.0, true)
        val expected = "DummyData=[" +
                "integer=123, " +
                "long=456, " +
                "string=lorem ipsum, " +
                "float=5.0, " +
                "double=10.0, " +
                "boolean=true" +
                "]"
        val sut = KotlinFormatter()

        val result = sut.format(data)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `formats class fields`() {
        val data = DummyData(123, 456L, "lorem ipsum", 5.0F, 10.0, true)
        val wrapper = WrapsData(data)
        val expected =
            "WrapsData=[" +
                    "data=DummyData(" +
                    "integer=123, " +
                    "long=456, " +
                    "string=lorem ipsum, " +
                    "float=5.0, " +
                    "double=10.0, " +
                    "boolean=true" +
                    ")]"
        val sut = KotlinFormatter()

        val result = sut.format(wrapper)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `formats kotlin object fields`() {
        val wrapper = WrapsAnObject(AnObject)
        val expected =
            "WrapsAnObject=[" +
                    "sealed=AnObject" +
                    "]"
        val sut = KotlinFormatter()

        val result = sut.format(wrapper)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `formats string primitives`() {
        val string = "lorem ipsum"
        val sut = KotlinFormatter()

        val result = sut.format(string)

        assertThat(result).isEqualTo(string)
    }

    @Test
    fun `formats integer primitives`() {
        val integer = 123
        val sut = KotlinFormatter()

        val result = sut.format(integer)

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats long primitives`() {
        val long = 123L
        val sut = KotlinFormatter()

        val result = sut.format(long)

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats float primitives`() {
        val float = 5.0f
        val sut = KotlinFormatter()

        val result = sut.format(float)

        assertThat(result).isEqualTo("5.0")
    }

    @Test
    fun `formats double primitives`() {
        val double = 5.0
        val sut = KotlinFormatter()

        val result = sut.format(double)

        assertThat(result).isEqualTo("5.0")
    }

    @Test
    fun `formats char primitives`() {
        val char = 'c'
        val sut = KotlinFormatter()

        val result = sut.format(char)

        assertThat(result).isEqualTo("c")
    }

    @Test
    fun `formats boolean primitives`() {
        val boolean = true
        val sut = KotlinFormatter()

        val result = sut.format(boolean)

        assertThat(result).isEqualTo("true")
    }

    @Test
    fun `formats byte primitives`() {
        val byte: Byte = 123
        val sut = KotlinFormatter()

        val result = sut.format(byte)

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats short primitives`() {
        val short: Short = 123
        val sut = KotlinFormatter()

        val result = sut.format(short)

        assertThat(result).isEqualTo("123")
    }

    data class WrapsAnObject(val sealed: Sealed)

    sealed class Sealed {
        object AnObject : Sealed()
    }

    data class WrapsData(val data: DummyData)

    data class DummyData(
        val integer: Int,
        val long: Long,
        val string: String,
        val float: Float,
        val double: Double,
        val boolean: Boolean
    )
}
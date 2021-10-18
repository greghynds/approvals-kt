package com.github.greghynds.approvals

import com.github.greghynds.approvals.PrintableExtensionsTest.Sealed.AnObject
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class PrintableExtensionsTest {

    @Test
    fun `formats string primitives as string literals`() {
        val string = "lorem ipsum"

        val result = string.toPrintableString()

        assertThat(result).isEqualTo(string)
    }

    @Test
    fun `formats integer primitives as string literals`() {
        val integer = 123

        val result = integer.toPrintableString()

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats long primitives as string literals`() {
        val long = 123L

        val result = long.toPrintableString()

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats float primitives as string literals`() {
        val float = 5.0f

        val result = float.toPrintableString()

        assertThat(result).isEqualTo("5.0")
    }

    @Test
    fun `formats double primitives as string literals`() {
        val double = 5.0

        val result = double.toPrintableString()

        assertThat(result).isEqualTo("5.0")
    }

    @Test
    fun `formats char primitives as string literals`() {
        val char = 'c'

        val result = char.toPrintableString()

        assertThat(result).isEqualTo("c")
    }

    @Test
    fun `formats boolean primitives as string literals`() {
        val boolean = true

        val result = boolean.toPrintableString()

        assertThat(result).isEqualTo("true")
    }

    @Test
    fun `formats byte primitives as string literals`() {
        val byte: Byte = 123

        val result = byte.toPrintableString()

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats short primitives as string literalsL`() {
        val short: Short = 123

        val result = short.toPrintableString()

        assertThat(result).isEqualTo("123")
    }

    @Test
    fun `formats primitive fields with name and value`() {
        val data = DummyData(123, 456L, "lorem ipsum", 5.0F, 10.0, true)
        val expected = "DummyData(" +
                "integer=123, " +
                "long=456, " +
                "string=lorem ipsum, " +
                "float=5.0, " +
                "double=10.0, " +
                "boolean=true" +
                ")"

        val result = data.toPrintableString()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `formats kotlin objects as simple class names`() {
        val anObject = AnObject

        val result = anObject.toPrintableString()

        assertThat(result).isEqualTo("AnObject")
    }

    @Test
    fun `formats class fields with class name and brackets`() {
        val data = DummyData(123, 456L, "lorem ipsum", 5.0F, 10.0, true)
        val wrapper = WrapsData(data)
        val expected =
            "WrapsData(" +
                    "data=DummyData(" +
                    "integer=123, " +
                    "long=456, " +
                    "string=lorem ipsum, " +
                    "float=5.0, " +
                    "double=10.0, " +
                    "boolean=true" +
                    "))"

        val result = wrapper.toPrintableString()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `formats kotlin object fields as simple class names`() {
        val wrapper = WrapsAnObject(AnObject)
        val expected =
            "WrapsAnObject(" +
                    "sealed=AnObject" +
                    ")"

        val result = wrapper.toPrintableString()

        assertThat(result).isEqualTo(expected)
    }

    private data class WrapsAnObject(val sealed: Sealed)

    private sealed class Sealed { object AnObject : Sealed() }

    private data class WrapsData(val data: DummyData)

    private data class DummyData(
        val integer: Int,
        val long: Long,
        val string: String,
        val float: Float,
        val double: Double,
        val boolean: Boolean
    )
}
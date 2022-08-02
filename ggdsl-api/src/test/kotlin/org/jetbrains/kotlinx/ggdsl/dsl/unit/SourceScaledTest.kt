package org.jetbrains.kotlinx.ggdsl.dsl.unit

import org.jetbrains.kotlinx.ggdsl.dsl.Symbol
import org.jetbrains.kotlinx.ggdsl.dsl.scaled
import org.jetbrains.kotlinx.ggdsl.ir.bindings.*
import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import org.jetbrains.kotlinx.ggdsl.ir.scale.*
import org.jetbrains.kotlinx.ggdsl.util.color.Color
import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.assertEquals

internal class SourceScaledTest {
    @Test
    fun testScaledUnspecified() {
        val ds = DataSource<Int>("ds1", typeOf<Int>())
        val scaledSource = ds.scaled()
        assertEquals(SourceScaledUnspecifiedDefault(ds), scaledSource)
    }

    @Test
    fun testScaledPositionalDefault() {
        val ds = DataSource<Double>("ds2", typeOf<Int>())
        val continuousScaledSource = ds.scaled(PositionalContinuousUnspecifiedScale())
        val categoricalScaledSource = ds.scaled(PositionalCategoricalUnspecifiedScale)
        assertEquals(
            SourceScaledPositionalUnspecified(ds, PositionalContinuousUnspecifiedScale()),
            continuousScaledSource
        )
        assertEquals(
            SourceScaledPositionalUnspecified(ds, PositionalCategoricalUnspecifiedScale),
            categoricalScaledSource
        )
    }

    @Test
    fun testScaledNonPositionalDefault() {
        val ds = DataSource<Double>("ds3", typeOf<Int>())
        val continuousScaledSource = ds.scaled(NonPositionalContinuousUnspecifiedScale())
        val categoricalScaledSource = ds.scaled(NonPositionalCategoricalUnspecifiedScale)
        assertEquals(
            SourceScaledNonPositionalUnspecified(ds, NonPositionalContinuousUnspecifiedScale()),
            continuousScaledSource
        )
        assertEquals(
            SourceScaledNonPositionalUnspecified(ds, NonPositionalCategoricalUnspecifiedScale),
            categoricalScaledSource
        )
    }

    @Test
    fun testScaledPositional() {
        val ds1 = DataSource<Float>("ds4", typeOf<Float>())
        val scale1 = PositionalContinuousScale(limits = 4.3F to 10F)
        val continuousScaledSource = ds1.scaled(scale1)
        assertEquals(
            SourceScaledPositional(ds1, scale1),
            continuousScaledSource
        )

        val ds2 = DataSource<String>("ds10", typeOf<String>())
        val scale2 = PositionalCategoricalScale(listOf<String>())
        val categoricalScaledSource = ds2.scaled(scale2)
        assertEquals(
            SourceScaledPositional(ds2, scale2),
            categoricalScaledSource
        )
    }

    @Test
    fun testScaledNonPositional() {
        val ds1 = DataSource<Char>("dsX", typeOf<Char>())
        val scale1 = NonPositionalContinuousScale(
            'a' to 'e',
            Color.fromHex("#000000") to Color.fromName("red")
        )
        val continuousScaledSource = ds1.scaled(scale1)
        assertEquals(
            SourceScaledNonPositional(ds1, scale1),
            continuousScaledSource
        )

        val ds2 = DataSource<String>("dsY", typeOf<String>())
        val scale2 = NonPositionalCategoricalScale<String, Symbol>(
            rangeValues = listOf(Symbol.CIRCLE, Symbol.TRIANGLE)
        )
        val categoricalScaledSource = ds2.scaled(scale2)
        assertEquals(
            SourceScaledNonPositional(ds2, scale2),
            categoricalScaledSource
        )
    }
}

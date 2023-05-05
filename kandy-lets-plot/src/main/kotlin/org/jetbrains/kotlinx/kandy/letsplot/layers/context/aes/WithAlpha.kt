/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.letsplot.layers.context.aes

import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.kandy.dsl.internal.BindingContext
import org.jetbrains.kotlinx.kandy.dsl.internal.checkInRange
import org.jetbrains.kotlinx.kandy.ir.bindings.NonPositionalMapping
import org.jetbrains.kotlinx.kandy.ir.scale.*
import org.jetbrains.kotlinx.kandy.letsplot.internal.ALPHA
import org.jetbrains.kotlinx.kandy.letsplot.internal.LetsPlotNonPositionalMappingParameters
import kotlin.reflect.KProperty

public interface WithAlpha : BindingContext {
    private fun checkInRange(value: Double) {
        checkInRange(ALPHA, value, 0.0..1.0)
    }

    private fun validateScale(scale: NonPositionalScale<*, out Double>) {
        when(scale) {
            is NonPositionalDefaultScale -> return
            is CustomNonPositionalScale -> return // TODO
            is NonPositionalCategoricalScale -> scale.rangeValues?.forEach {
                checkInRange(it)
            }
            is NonPositionalContinuousScale -> {
                scale.rangeMin?.let { checkInRange(it) }
                scale.rangeMax?.let { checkInRange(it) }
            }
        }
    }

    private fun validateParameters(parameters: LetsPlotNonPositionalMappingParameters<*, Double>) {
        validateScale(parameters.scale)
    }

    public var alpha: Double?
        get() = null
        set(value) {
            value?.let { checkInRange(it) }
            addNonPositionalSetting(ALPHA, value)
        }

    public fun <T> alpha(
        column: ColumnReference<T>,
        parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping<T, Double>(
            ALPHA,
            column.name(),
            LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters).also {
                validateParameters(it)
            }
        )
    }

    public fun <T> alpha(
        column: KProperty<T>,
        parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping<T, Double>(
            ALPHA,
            column.name,
            LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters).also {
                validateParameters(it)
            }
        )
    }

    public fun alpha(
        column: String,
        parameters: LetsPlotNonPositionalMappingParameters<Any?, Double>.() -> Unit = {}
    ): NonPositionalMapping<Any?, Double> {
        return addNonPositionalMapping<Any?, Double>(
            ALPHA,
            column,
            LetsPlotNonPositionalMappingParameters<Any?, Double>().apply(parameters).also {
                validateParameters(it)
            }
        )
    }

    public fun <T> alpha(
        values: Iterable<T>,
        name: String? = null,
        parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping<T, Double>(
            ALPHA,
            values.toList(),
            name,
            LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters).also {
                validateParameters(it)
            }
        )
    }

    public fun <T> alpha(
        values: DataColumn<T>,
        //name: String? = null,
        parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping<T, Double>(
            ALPHA,
            values,
            LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters).also {
                validateParameters(it)
            }
        )
    }
}
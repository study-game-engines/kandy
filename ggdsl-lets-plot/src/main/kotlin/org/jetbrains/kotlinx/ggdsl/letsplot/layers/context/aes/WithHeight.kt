package org.jetbrains.kotlinx.ggdsl.letsplot.layers.context.aes

import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.dsl.internal.BindingContext
import org.jetbrains.kotlinx.ggdsl.ir.bindings.NonPositionalMapping
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.HEIGHT

public interface WithHeight : BindingContext {
    public var height: Double?
        get() = null
        set(value) {
            addNonPositionalSetting(HEIGHT, value)
        }
    public fun <T> height(
        column: ColumnReference<T>,
        //parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping<T, Double>(
            HEIGHT,
            column.name(),
            null//LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters)
        )
    }

    public fun height(
        column: String,
       // parameters: LetsPlotNonPositionalMappingParameters<Any?, Double>.() -> Unit = {}
    ): NonPositionalMapping<Any?, Double> {
        return addNonPositionalMapping(
            HEIGHT,
            column,
            null
            //LetsPlotNonPositionalMappingParameters<Any?, Double>().apply(parameters)
        )
    }

    // Iterable, Array, PrimArray, DataColumn,
    public fun <T> height(
        values: Iterable<T>,
        name: String? = null,
        //parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping(
            HEIGHT,
            values.toList(),
            name,
            null
            //LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters)
        )
    }

    public fun <T> height(
        values: DataColumn<T>,
        //name: String? = null,
        //parameters: LetsPlotNonPositionalMappingParameters<T, Double>.() -> Unit = {}
    ): NonPositionalMapping<T, Double> {
        return addNonPositionalMapping(
            HEIGHT,
            values.toList(),
            values.name(),
            null
           // LetsPlotNonPositionalMappingParameters<T, Double>().apply(parameters)
        )
    }
}
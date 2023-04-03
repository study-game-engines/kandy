package org.jetbrains.kotlinx.kandy.letsplot

import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.kandy.dsl.internal.BindingContext
import org.jetbrains.kotlinx.kandy.dsl.internal.PlotContext
import org.jetbrains.kotlinx.kandy.ir.aes.AesName
import org.jetbrains.kotlinx.kandy.ir.bindings.PositionalFreeScale
import org.jetbrains.kotlinx.kandy.ir.bindings.PositionalMapping
import org.jetbrains.kotlinx.kandy.ir.bindings.PositionalMappingParameters
import org.jetbrains.kotlinx.kandy.ir.scale.PositionalContinuousScale
import org.jetbrains.kotlinx.kandy.letsplot.internal.LetsPlotPositionalMappingParameters
import org.jetbrains.kotlinx.kandy.letsplot.internal.X
import org.jetbrains.kotlinx.kandy.letsplot.internal.Y
import org.jetbrains.kotlinx.kandy.letsplot.scales.guide.Axis

public fun <T> PlotContext.x(
    column: ColumnReference<T>,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(X, column.name(), LetsPlotPositionalMappingParameters<T>().apply(parameters))
}

public fun <T> PlotContext.x(
    values: Iterable<T>,
    name: String? = null,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(
        X,
        values.toList(),
        name,
        LetsPlotPositionalMappingParameters<T>().apply(parameters)
    )
}

public fun PlotContext.x(
    column: String,
    parameters: LetsPlotPositionalMappingParameters<Any?>.() -> Unit = {}
): PositionalMapping<Any?> {
    return addPositionalMapping<Any?>(X, column, LetsPlotPositionalMappingParameters<Any?>().apply(parameters))
}

public fun <T> PlotContext.x(
    values: DataColumn<T>,
    //name: String? = null,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(
        X,
        values,
        LetsPlotPositionalMappingParameters<T,>().apply(parameters)
    )
}

@Suppress("UNCHECKED_CAST")
public val PlotContext.x: AxisParameters
    get() {
        return AxisParameters(bindingCollector.freeScales.getOrPut(X) {
            PositionalFreeScale(X, LetsPlotPositionalMappingParameters<Any?>())
        }.parameters as LetsPlotPositionalMappingParameters<Any?>, X, this)
    }

public fun PlotContext.x(
    parameters: AxisParameters.() -> Unit = {}
) {
    x.apply(parameters)
}

/*
public fun <T> PlotContext.y(value: T): PositionalSetting<T> {
    return addPositionalSetting(Y, value)
}

 */

public fun <T> PlotContext.y(
    column: ColumnReference<T>,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(Y, column.name(), LetsPlotPositionalMappingParameters<T>().apply(parameters))
}

public fun <T> PlotContext.y(
    values: Iterable<T>,
    name: String? = null,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(
        Y,
        values.toList(),
        name,
        LetsPlotPositionalMappingParameters<T>().apply(parameters)
    )
}

public fun PlotContext.y(
    column: String,
    parameters: LetsPlotPositionalMappingParameters<Any?>.() -> Unit = {}
): PositionalMapping<Any?> {
    return addPositionalMapping<Any?>(Y, column, LetsPlotPositionalMappingParameters<Any?>().apply(parameters))
}

public fun <T> PlotContext.y(
    values: DataColumn<T>,
    //name: String? = null,
    parameters: LetsPlotPositionalMappingParameters<T>.() -> Unit = {}
): PositionalMapping<T> {
    return addPositionalMapping<T>(
        Y,
        values,
        LetsPlotPositionalMappingParameters<T,>().apply(parameters)
    )
}

@Suppress("UNCHECKED_CAST")
public val PlotContext.y: AxisParameters
    get() {
        return AxisParameters(bindingCollector.freeScales.getOrPut(Y) {
            PositionalFreeScale(Y, LetsPlotPositionalMappingParameters<Any?>())
        }.parameters as LetsPlotPositionalMappingParameters<Any?>, Y, this)
    }

public fun PlotContext.y(
    parameters: AxisParameters.() -> Unit = {}
) {
    y.apply(parameters)
}

// todo
public class AxisParameters(
    private val mappingParameters: LetsPlotPositionalMappingParameters<Any?>,
    private val aesName: AesName,
    private val bindingContext: BindingContext,
): PositionalMappingParameters<Any?> by mappingParameters {

    public var limits: ClosedRange<*>? = null
        set(value) {
            mappingParameters.scale = PositionalContinuousScale(value?.start,
                value?.endInclusive,
                null, null)
            field = value
        }
   public val axis: Axis<Any?>
        get() = mappingParameters.axis

    public fun constant(value: Any?) {
        bindingContext.addPositionalSetting(aesName, value)
    }
}

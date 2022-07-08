package org.jetbrains.kotlinx.ggdsl.letsplot.scales

import org.jetbrains.kotlinx.ggdsl.ir.bindings.BaseScaledNonPositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.bindings.BaseScaledPositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.scale.ScaleParameters
import org.jetbrains.kotlinx.ggdsl.letsplot.scales.guide.Axis
import org.jetbrains.kotlinx.ggdsl.letsplot.scales.guide.Legend

interface LetsPlotScaleParameters : ScaleParameters

data class PositionalParameters<DomainType : Any>(val axis: Axis<DomainType>) : LetsPlotScaleParameters
data class NonPositionalParameters<DomainType : Any, RangeType : Any>
    (val legend: Legend<DomainType, RangeType>) : LetsPlotScaleParameters

fun <DomainType : Any> BaseScaledPositionalMapping<DomainType>.with(
    block: PositionalParameters<DomainType>.() -> Unit
) {
    scaleParameters = PositionalParameters(Axis<DomainType>()).apply(block)
}

fun <DomainType : Any, RangeType : Any> BaseScaledNonPositionalMapping<DomainType, RangeType>.with(
    block: NonPositionalParameters<DomainType, RangeType>.() -> Unit
) {
    scaleParameters = NonPositionalParameters(Legend<DomainType, RangeType>()).apply(block)
}

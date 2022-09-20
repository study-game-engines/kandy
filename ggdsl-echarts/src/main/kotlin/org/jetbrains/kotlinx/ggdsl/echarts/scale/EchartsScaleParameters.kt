/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.echarts.scale

import org.jetbrains.kotlinx.ggdsl.echarts.scale.guide.Axis
import org.jetbrains.kotlinx.ggdsl.echarts.scale.guide.Legend
import org.jetbrains.kotlinx.ggdsl.ir.bindings.BaseScaledNonPositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.bindings.BaseScaledPositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.scale.ScaleParameters


interface EchartsScaleParameters : ScaleParameters

data class PositionalParameters<DomainType : Any>(val axis: Axis<DomainType>) : EchartsScaleParameters
data class NonPositionalParameters<DomainType : Any, RangeType : Any>
    (val legend: Legend<DomainType, RangeType>) : EchartsScaleParameters

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

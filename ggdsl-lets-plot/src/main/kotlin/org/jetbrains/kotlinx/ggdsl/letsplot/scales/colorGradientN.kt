package org.jetbrains.kotlinx.ggdsl.letsplot.scales

import org.jetbrains.kotlinx.ggdsl.ir.scale.ContinuousScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.CustomNonPositionalScale
import org.jetbrains.kotlinx.ggdsl.util.color.Color

data class ScaleContinuousColorGradientN<DomainType: Any>(
    val domainLimits: Pair<DomainType, DomainType>? = null,
    val rangeColors: List<Color>,
    override val transform: Transformation? = null
): ContinuousScale, CustomNonPositionalScale<DomainType, Color>

fun<DomainType: Any> continuousColorGradientN(
    domainLimits: Pair<DomainType, DomainType>? = null,
    rangeColors: List<Color>,
    transform: Transformation? = null
) = ScaleContinuousColorGradientN(
    domainLimits, rangeColors, transform
)

data class ScaleContinuousColorGradient2<DomainType: Any>(
    val domainLimits: Pair<DomainType, DomainType>? = null,
    val low: Color,
    val mid: Color,
    val high: Color,
    val midpoint: Double,
    override val transform: Transformation? = null
): ContinuousScale, CustomNonPositionalScale<DomainType, Color>

fun<DomainType: Any> continuousColorGradient2(
    domainLimits: Pair<DomainType, DomainType>? = null,
    low: Color,
     mid: Color,
     high: Color,
     midpoint: Double,
    transform: Transformation? = null
) = ScaleContinuousColorGradient2(
    domainLimits, low, mid, high, midpoint, transform
)
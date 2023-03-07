/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.letsplot.scales

import org.jetbrains.kotlinx.ggdsl.ir.scale.ContinuousScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.CustomNonPositionalScale
import org.jetbrains.kotlinx.ggdsl.util.color.Color

// todo categorical

//@Serializable
public data class ScaleContinuousColorGradientN<DomainType>(
    val domainLimits: Pair<DomainType & Any, DomainType & Any>?,
    val rangeColors: List<Color>,
    override val nullValue: Color?,
    override val transform: Transformation?
) : ContinuousScale<Color>, CustomNonPositionalScale<DomainType, Color>

/**
 * Creates smooth color gradient between multiple colors.
 *
 * @param DomainType type of domain
 * @param domainLimits segment defining the domain
 * @param transform the transformation of scale
 * @return new [ContinuousScale]/[CustomNonPositionalScale] with given limits
 */
public inline fun <reified DomainType> continuousColorGradientN(
    rangeColors: List<Color>,
    domainLimits: Pair<DomainType & Any, DomainType & Any>? = null,
    nullValue: Color? = null,
    transform: Transformation? = null
): ScaleContinuousColorGradientN<DomainType> = ScaleContinuousColorGradientN(
    domainLimits, rangeColors, nullValue, transform
)

//@Serializable
public data class ScaleContinuousColorGradient2<DomainType>(
    val domainLimits: Pair<DomainType, DomainType>? = null,
    val low: Color,
    val mid: Color,
    val high: Color,
    val midpoint: Double,
    override val nullValue: Color?,
    override val transform: Transformation?
) : ContinuousScale<Color>, CustomNonPositionalScale<DomainType, Color>

/**
 * Creates diverging color gradient (low-mid-high) for color aesthetic.
 *
 * TODO
 * @param DomainType type of domain
 * @param domainLimits segment defining the domain
 * @param transform the transformation of scale
 * @return new [ContinuousScale]/[CustomNonPositionalScale] with given limits
 */
public inline fun <reified DomainType> continuousColorGradient2(
    low: Color,
    mid: Color,
    high: Color,
    midpoint: Double,
    domainLimits: Pair<DomainType & Any, DomainType & Any>? = null,
    nullValue: Color? = null,
    transform: Transformation? = null
): ScaleContinuousColorGradient2<DomainType> = ScaleContinuousColorGradient2(
    domainLimits, low, mid, high, midpoint, nullValue, transform
)

/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.ir.bindings

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.ir.scale.*

/**
 * Scaled source base interface.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied
 * @property scale applying scale.
 */
public sealed interface ColumnScaled<DomainType> {
    public val source: ColumnReference<DomainType>
    public val scale: Scale
}

/**
 * Scaled unspecified default source.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied.
 * @property scale applying unspecified default scale.
 */
@Serializable
public data class ColumnScaledUnspecifiedDefault<DomainType>(
    override val source: ColumnReference<DomainType>,
) : ColumnScaled<DomainType> {
    override val scale: DefaultUnspecifiedScale = DefaultUnspecifiedScale
}

/**
 * Scaled positional default source.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied.
 * @property scale applying positional default scale.
 */
@Serializable
public data class ColumnScaledPositionalUnspecified<DomainType>(
    override val source: ColumnReference<DomainType>,
    override val scale: PositionalUnspecifiedScale
) : ColumnScaled<DomainType>

/**
 * Scaled non-positional default source.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied.
 * @property scale applying non-positional default scale.
 */
@Serializable
public data class ColumnScaledNonPositionalUnspecified<DomainType>(
    override val source: ColumnReference<DomainType>,
    override val scale: NonPositionalUnspecifiedScale
) : ColumnScaled<DomainType>

/**
 * Scaled positional source.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied.
 * @property scale applying positional scale.
 */
@Serializable
public data class ColumnScaledPositional<DomainType>(
    override val source: ColumnReference<DomainType>,
    override val scale: PositionalScale<DomainType>
) : ColumnScaled<DomainType>

/**
 * Scaled a non-positional source.
 *
 * @property DomainType the type of domain.
 * @property source the source to which the scale is applied.
 * @property scale applying non-positional scale.
 */
@Serializable
public data class ColumnScaledNonPositional<DomainType, RangeType>(
    override val source: ColumnReference<DomainType>,
    override val scale: NonPositionalScale<DomainType, RangeType>
) : ColumnScaled<DomainType>

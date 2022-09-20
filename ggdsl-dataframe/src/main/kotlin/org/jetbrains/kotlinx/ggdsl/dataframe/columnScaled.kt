package org.jetbrains.kotlinx.ggdsl.dataframe

import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.ir.bindings.*
import org.jetbrains.kotlinx.ggdsl.ir.scale.NonPositionalScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.NonPositionalUnspecifiedScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.PositionalScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.PositionalUnspecifiedScale

/**
 *  Apply a default scale to this column
 */
public inline fun <reified DomainType : Any> ColumnReference<DomainType>.scaled(): SourceScaledUnspecifiedDefault<DomainType> =
    SourceScaledUnspecifiedDefault(this.toDataSource())

/**
 * Apply an unspecified positional scale to this column
 *
 * @param DomainType type of domain
 * @param scale positional default scale
 * @return scaled source
 */
public inline fun <reified DomainType : Any> ColumnReference<DomainType>.scaled(scale: PositionalUnspecifiedScale): SourceScaledPositionalUnspecified<DomainType> =
    SourceScaledPositionalUnspecified(this.toDataSource(), scale)

/**
 * Apply an unspecified non-positional scale to this column
 *
 * @param DomainType type of domain
 * @param scale non-positional default scale
 * @return scaled source
 */
public inline fun <reified DomainType : Any> ColumnReference<DomainType>.scaled(scale: NonPositionalUnspecifiedScale): SourceScaledNonPositionalUnspecified<DomainType> =
    SourceScaledNonPositionalUnspecified(this.toDataSource(), scale)

/**
 * Apply a positional scale to this column
 *
 * @param DomainType type of domain
 * @param scale positional scale
 * @return scaled source
 */
public inline fun <reified DomainType : Any> ColumnReference<DomainType>.scaled(
    scale: PositionalScale<DomainType>
): SourceScaledPositional<DomainType> = SourceScaledPositional(this.toDataSource(), scale)

/**
 * Apply a non-positional scale to this column
 *
 * @param DomainType type of domain
 * @param scale non-positional scale
 * @return scaled source
 */
public inline fun <reified DomainType : Any, RangeType : Any> ColumnReference<DomainType>.scaled(
    scale: NonPositionalScale<DomainType, RangeType>
): SourceScaledNonPositional<DomainType, RangeType> = SourceScaledNonPositional(this.toDataSource(), scale)

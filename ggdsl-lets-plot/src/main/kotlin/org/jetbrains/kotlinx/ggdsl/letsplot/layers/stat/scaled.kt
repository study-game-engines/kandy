package org.jetbrains.kotlinx.ggdsl.letsplot.layers.stat

import org.jetbrains.kotlinx.ggdsl.ir.bindings.*
import org.jetbrains.kotlinx.ggdsl.ir.scale.NonPositionalScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.NonPositionalUnspecifiedScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.PositionalScale
import org.jetbrains.kotlinx.ggdsl.ir.scale.PositionalUnspecifiedScale


inline fun <reified DomainType : Any> Stat<DomainType>.scaled() =
    SourceScaledUnspecifiedDefault(this.toDataSource())


inline fun <reified DomainType : Any> Stat<DomainType>.scaled(scale: PositionalUnspecifiedScale) =
    SourceScaledPositionalUnspecified(this.toDataSource(), scale)



inline fun <reified DomainType : Any> Stat<DomainType>.scaled(scale: NonPositionalUnspecifiedScale) =
    SourceScaledNonPositionalUnspecified(this.toDataSource(), scale)


inline fun <reified DomainType : Any> Stat<DomainType>.scaled(
    scale: PositionalScale<DomainType>
) = SourceScaledPositional(this.toDataSource(), scale)


inline fun <reified DomainType : Any, RangeType : Any> Stat<DomainType>.scaled(
    scale: NonPositionalScale<DomainType, RangeType>
) = SourceScaledNonPositional(this.toDataSource(), scale)
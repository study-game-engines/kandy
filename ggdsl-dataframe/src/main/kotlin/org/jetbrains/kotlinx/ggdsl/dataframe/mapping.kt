package org.jetbrains.kotlinx.ggdsl.dataframe

import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.dsl.scaled
import org.jetbrains.kotlinx.ggdsl.ir.aes.MappableNonPositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.aes.NonScalablePositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.aes.ScalablePositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.bindings.NonScalablePositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.bindings.ScaledUnspecifiedDefaultNonPositionalMapping
import org.jetbrains.kotlinx.ggdsl.ir.bindings.ScaledUnspecifiedDefaultPositionalMapping
import kotlin.reflect.typeOf

inline operator fun <reified DomainType : Any> NonScalablePositionalAes.invoke(
    columnRef: ColumnReference<DomainType>
) {
    context.bindingCollectorAccessor.mappings[this.name] =
        NonScalablePositionalMapping(this.name, columnRef.toDataSource(), typeOf<DomainType>())
}

inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    columnRef: ColumnReference<DomainType>
): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
    val mapping = ScaledUnspecifiedDefaultPositionalMapping(
        this.name,
        columnRef.toDataSource().scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
    columnRef: ColumnReference<DomainType>
): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
    val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
        this.name,
        columnRef.toDataSource().scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}
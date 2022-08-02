package org.jetbrains.kotlinx.ggdsl.dsl

import org.jetbrains.kotlinx.ggdsl.ir.aes.MappableNonPositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.aes.NonPositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.aes.NonScalablePositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.aes.ScalablePositionalAes
import org.jetbrains.kotlinx.ggdsl.ir.bindings.*
import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import kotlin.reflect.typeOf

/**
 * Sets the given constant value to this non-positional aesthetic attribute
 *
 * @param value the assigned value.
 */
operator fun <T : Any> NonPositionalAes<T>.invoke(value: T) {
    context.bindingCollectorAccessor.settings[this.name] = NonPositionalSetting(this.name, value)
}

/**
 * Maps the given [DataSource] to this non-scalable ("sub-positional") aesthetic attribute.
 *
 * @param source the mapped raw data source.
 */
inline operator fun <reified DomainType : Any> NonScalablePositionalAes.invoke(
    source: DataSource<DomainType>
) {
    context.bindingCollectorAccessor.mappings[this.name] =
        NonScalablePositionalMapping(this.name, source, typeOf<DomainType>())
}

/**
 * Maps the given [Iterable] to this non-scalable ("sub-positional") aesthetic attribute.
 *
 * @param data the mapped raw data.
 */
inline operator fun <reified DomainType : Any> NonScalablePositionalAes.invoke(
    data: Iterable<DomainType>
) {
    context.bindingCollectorAccessor.mappings[this.name] =
        NonScalablePositionalMapping(this.name, with(context) { data.toDataSource() }, typeOf<DomainType>())
}

/**
 * Maps the given [DataSource] to this positional aesthetic attribute with default scale.
 *
 * @param source the mapped raw data source.
 */
inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    source: DataSource<DomainType>
): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
    val mapping = ScaledUnspecifiedDefaultPositionalMapping(
        this.name,
        source.scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given [Iterable] to this positional aesthetic attribute with default scale.
 *
 * @param data the mapped raw data.
 */
inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    data: Iterable<DomainType>
): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
    val mapping = ScaledUnspecifiedDefaultPositionalMapping(
        this.name,
        with(context) { data.toDataSource() }.scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given [DataSource] to this non-positional aesthetic attribute with default scale.
 *
 * @param source the mapped raw data source.
 */
inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
    source: DataSource<DomainType>
): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
    val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
        this.name,
        source.scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given [Iterable] to this non-positional aesthetic attribute with default scale.
 *
 * @param data the mapped raw data.
 */
inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
    data: Iterable<DomainType>
): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
    val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
        this.name,
        with(context) { data.toDataSource() }.scaled(),
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given scaled source to this positional aesthetic attribute with unspecified scale.
 *
 * @param sourceScaledDefault the mapped source scaled default.
 */
inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    sourceScaledDefault: SourceScaledUnspecifiedDefault<DomainType>
): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
    val mapping = ScaledUnspecifiedDefaultPositionalMapping(
        this.name,
        sourceScaledDefault,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given scaled source to this non-positional aesthetic attribute with unspecified scale.
 *
 * @param sourceScaledDefault the mapped source scaled default.
 */
inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
    sourceScaledDefault: SourceScaledUnspecifiedDefault<DomainType>
): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
    val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
        this.name,
        sourceScaledDefault,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given scaled source to this positional aesthetic attribute with default scale.
 *
 * @param sourceScaledDefault the mapped source scaled unspecified positional.
 */
inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    sourceScaledDefault: SourceScaledPositionalUnspecified<DomainType>
): ScaledPositionalDefaultMapping<DomainType> {
    val mapping = ScaledPositionalDefaultMapping(
        this.name,
        sourceScaledDefault,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}


/**
 * Maps the given scaled source to this non-positional aesthetic attribute with unspecified scale.
 *
 * @param sourceScaledDefault the mapped source scaled unspecified non-positional.
 */
inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
    sourceScaledDefault: SourceScaledNonPositionalUnspecified<DomainType>
): ScaledNonPositionalDefaultMapping<DomainType, RangeType> {
    val mapping = ScaledNonPositionalDefaultMapping<DomainType, RangeType>(
        this.name,
        sourceScaledDefault,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given scaled source to this positional aesthetic attribute.
 *
 * @param sourceScaledPositional the mapped source scaled positional.
 */
inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
    sourceScaledPositional: SourceScaledPositional<DomainType>
): ScaledPositionalMapping<DomainType> {
    val mapping = ScaledPositionalMapping(
        this.name,
        sourceScaledPositional,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

/**
 * Maps the given scaled source to this non-positional aesthetic attribute.
 *
 * @param sourceScaledNonPositional the mapped source scaled non-positional.
 */
inline operator fun <reified DomainType : Any, reified RangeType : Any>
        MappableNonPositionalAes<RangeType>.invoke(
    sourceScaledNonPositional: SourceScaledNonPositional<DomainType, RangeType>
): ScaledNonPositionalMapping<DomainType, RangeType> {
    val mapping = ScaledNonPositionalMapping(
        this.name,
        sourceScaledNonPositional,
        typeOf<DomainType>()
    )
    context.bindingCollectorAccessor.mappings[this.name] = mapping
    return mapping
}

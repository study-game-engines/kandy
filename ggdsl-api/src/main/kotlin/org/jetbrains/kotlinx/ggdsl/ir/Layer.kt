package org.jetbrains.kotlinx.ggdsl.ir

import org.jetbrains.kotlinx.ggdsl.ir.aes.Aes
import org.jetbrains.kotlinx.ggdsl.ir.bindings.Mapping
import org.jetbrains.kotlinx.ggdsl.ir.bindings.Setting
import org.jetbrains.kotlinx.ggdsl.ir.data.NamedData
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.LayerFeature
import org.jetbrains.kotlinx.ggdsl.ir.geom.Geom

/**
 * Layer is a collection of data and mappings from it.
 * It is characterized by its [Geom].
 *
 * @param data the dataset of this layer.
 * @param geom the [Geom] that describes this layer.
 * @param mappings the [Map] of the mappings; keys are aesthetic attributes,
 * values are mappings on corresponding attributes.
 * @param settings the [Map] of the setting; keys are aesthetic attributes,
 * values are setting of corresponding attributes.
 * @param features the [Map] of the layer features; keys are feature names,
 * values are features with corresponding names.
 */
data class Layer(
    val data: NamedData? = null,
    val geom: Geom,
    val mappings: Map<Aes, Mapping>,
    val settings: Map<Aes, Setting>,
    val features: Map<FeatureName, LayerFeature> = emptyMap()
)
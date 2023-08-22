/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.contexts

import io.mockk.mockk
import org.jetbrains.kotlinx.kandy.dsl.internal.BindingCollector
import org.jetbrains.kotlinx.kandy.dsl.internal.DatasetHandler
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerContextInterface
import org.jetbrains.kotlinx.kandy.dsl.internal.PlotContext
import org.jetbrains.kotlinx.kandy.ir.aes.Aes
import org.jetbrains.kotlinx.kandy.ir.feature.FeatureName
import org.jetbrains.kotlinx.kandy.ir.feature.LayerFeature
import org.jetbrains.kotlinx.kandy.ir.geom.Geom
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Test class for LayerContextInterface
 */
class LayerContextInterfaceTest {

    @Test
    fun `test toLayer`() {
        val mockGeom = mockk<Geom>()
        val layersInheritMappings = true

        val layerContextInterface = object : LayerContextInterface {
            override val geom: Geom = mockGeom
            override val layerFeatures: MutableMap<FeatureName, LayerFeature> = mutableMapOf()
            override val requiredAes: Set<Aes> = setOf()
            override val plotContext: PlotContext = mockk()
            override val datasetIndex: Int = 0
            override val bindingCollector: BindingCollector = BindingCollector()
            override val datasetHandler: DatasetHandler = mockk()
        }

        val layer = layerContextInterface.toLayer(layersInheritMappings)

        assertEquals(layerContextInterface.datasetIndex, layer.datasetIndex)
        assertEquals(mockGeom, layer.geom)
        assertEquals(layerContextInterface.bindingCollector.mappings, layer.mappings)
        assertEquals(layerContextInterface.bindingCollector.settings, layer.settings)
        assertEquals(layerContextInterface.bindingCollector.freeScales, layer.freeScales)
        assertEquals(layerContextInterface.layerFeatures, layer.features)
        assertEquals(layersInheritMappings, layer.inheritsBindings)
    }
}
/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.letsplot

import org.jetbrains.kotlinx.ggdsl.dsl.PlotContext
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.PlotFeature

object CoordFlip: PlotFeature {
    val FEATURE_NAME = FeatureName("COORD_FLIP")
    override val featureName = FEATURE_NAME
}

fun PlotContext.coordFlip(){
    features[CoordFlip.FEATURE_NAME] = CoordFlip
}

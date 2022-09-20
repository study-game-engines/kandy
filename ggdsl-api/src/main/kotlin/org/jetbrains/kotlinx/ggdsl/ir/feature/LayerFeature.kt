/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.ir.feature

/**
 * Base interface for layer feature
 *
 * @property featureName the name of feature
 */
interface LayerFeature {
    val featureName: FeatureName // todo remove?
}

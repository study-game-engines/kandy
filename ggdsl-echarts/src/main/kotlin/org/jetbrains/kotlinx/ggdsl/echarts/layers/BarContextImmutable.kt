/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.echarts.layers

// import org.jetbrains.kotlinx.ggdsl.dsl.internal.PlotDslMarker
import org.jetbrains.kotlinx.ggdsl.dsl.internal.LayerCollectorContext
import org.jetbrains.kotlinx.ggdsl.echarts.aes.WithAlpha
import org.jetbrains.kotlinx.ggdsl.echarts.aes.WithColor
import org.jetbrains.kotlinx.ggdsl.echarts.aes.WithX
import org.jetbrains.kotlinx.ggdsl.echarts.aes.WithY
import org.jetbrains.kotlinx.ggdsl.echarts.features.animation.Animation
import org.jetbrains.kotlinx.ggdsl.echarts.features.animation.AnimationEasing

/**
 * Bar settings.
 *
 * @property x mapping data on the x-axis.
 * @property y mapping data on the y-axis.
 * @property color bars [color][org.jetbrains.kotlinx.ggdsl.util.color.Color].
 * @property alpha bars opacity.
 * @property animation [animation][Animation]
 *
 * @see bars
 * @see org.jetbrains.kotlinx.ggdsl.util.color.Color
 * @see Animation
 */
/*@PlotDslMarker*/
public class BarContextImmutable(parent: LayerCollectorContext) : EchartsLayerContext(parent), WithX, WithY, WithColor,
    WithAlpha {
    /**
     * Animation options settings for [bars][bars].
     * If a property isn't set or set to null, a default value will be used.
     *
     * * [enable][Animation.enable] - responsible for enabling animation.
     * By default `true`.
     * * [threshold][Animation.threshold] - sets a graphic number threshold for animation.
     * Animation will be disabled when graphic number exceeds a threshold.
     * By default `2000`.
     * * [duration][Animation.duration] - duration of the first animation.
     * By default `1000`.
     * * [easing][Animation.easing] - [easing effect][AnimationEasing] used for the first animation.
     * By default `cubicOut`.
     * * [delay][Animation.delay] - delay before updating the first animation.
     * By default `0`.
     *
     * ```kotlin
     * plot {
     *  bars {
     *      animation {
     *          enable = true
     *          threshold = 2000
     *          duration = 1000
     *          easing = AnimationEasing.CUBIC_OUT
     *          delay = 0
     *      }
     *  }
     * }
     * ```
     *
     * @see AnimationEasing
     */
    public val animation: Animation = Animation()
}
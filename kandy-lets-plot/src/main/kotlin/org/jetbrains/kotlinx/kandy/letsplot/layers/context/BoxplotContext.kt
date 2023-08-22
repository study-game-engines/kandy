/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.letsplot.layers.context

import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCollectorContext
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerContextInterface
import org.jetbrains.kotlinx.kandy.ir.aes.Aes
import org.jetbrains.kotlinx.kandy.ir.geom.Geom
import org.jetbrains.kotlinx.kandy.letsplot.internal.*
import org.jetbrains.kotlinx.kandy.letsplot.layers.context.aes.*
import org.jetbrains.kotlinx.kandy.letsplot.layers.geom.BOXPLOT

public interface BoxplotInterface : LayerContextInterface, WithX, WithAlpha,
    WithFillColor, WithWidth,
    WithLower, WithUpper, WithMiddle, WithYMin, WithYMax, WithFatten, WithYFree {
    override val geom: Geom
        get() = BOXPLOT
    override val requiredAes: Set<Aes> get() = setOf(X, LOWER, UPPER, MIDDLE, Y_MIN, Y_MAX)
}

public open class BoxplotContext(parent: LayerCollectorContext) : LayerWithBorderLineContext(parent), BoxplotInterface

/*import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCollectorContext
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCollectorContextImmutable
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerCollectorContextMutable
import org.jetbrains.kotlinx.kandy.dsl.internal.LayerContext
// import org.jetbrains.kotlinx.kandy.dsl.internal.PlotDslMarker
import org.jetbrains.kotlinx.kandy.letsplot.internal.*

public class BoxplotContext(parent: LayerCollectorContext): LayerContext(parent) {
    public val x: XAes get() = XAes(this)

    public val lower: LowerAes get() = LowerAes(this)
    public val upper: UpperAes get() = UpperAes(this)
    public val middle: MiddleAes get() = MiddleAes(this)
    public val yMin: YMinAes get() = YMinAes(this)
    public val yMax: YMaxAes get() = YMaxAes(this)

    public val fatten: FattenAes get() = FattenAes(this)

    public val color: FillAes get() = FillAes(this)
    public val alpha: AlphaAes get() = AlphaAes(this)
}*/

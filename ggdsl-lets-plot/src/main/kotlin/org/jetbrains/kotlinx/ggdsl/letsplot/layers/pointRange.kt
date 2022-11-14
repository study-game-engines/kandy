/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.letsplot.layers

import org.jetbrains.kotlinx.ggdsl.dsl.PlotDslMarker
import org.jetbrains.kotlinx.ggdsl.dsl.internal.*
import org.jetbrains.kotlinx.ggdsl.letsplot.*
import org.jetbrains.kotlinx.ggdsl.util.context.SelfInvocationContext

@PublishedApi
internal val POINT_RANGE: LetsPlotGeom = LetsPlotGeom("pointrange")

public interface InnerPointSubContextInterface: SelfInvocationContext {
    public val parentContext: BindingContext
    public val symbol: ShapeAes get() = ShapeAes(parentContext)
    public val fillColor: FillAes get() = FillAes(parentContext)
    public val fatten: FattenAes get() = FattenAes(parentContext)
}

public class InnerPointSubContextImmutable(override val parentContext: BindingContext) : InnerPointSubContextInterface

public class InnerPointSubContextMutable(override val parentContext: TableBindingContextInterfaceMutable) :
    InnerPointSubContextInterface, TableSubContextMutable(parentContext, false, false)

public interface InnerLineSubContextInterface: SelfInvocationContext {
    public val parentContext: BindingContext
    public val type: LineTypeAes get() = LineTypeAes(parentContext)
}

public class InnerLineSubContextImmutable(override val parentContext: BindingContext) : InnerLineSubContextInterface

public class InnerLineSubContextMutable(override val parentContext: TableBindingContextInterfaceMutable) :
    InnerLineSubContextInterface, TableSubContextMutable(parentContext, false, false)

public interface PointRangeContextInterface : BindingContext {
    public val x: XAes get() = XAes(this)
    public val y: YAes get() = YAes(this)
    public val yMin: YMinAes get() = YMinAes(this)
    public val yMax: YMaxAes get() = YMaxAes(this)

    public val alpha: AlphaAes get() = AlphaAes(this)
    public val color: ColorAes get() = ColorAes(this)

    // todo separate????
    public val size: SizeAes get() = SizeAes(this)

    public val innerPoint: InnerPointSubContextInterface

    public val innerLine: InnerLineSubContextInterface
}

@PlotDslMarker
public class PointRangeContextImmutable(parent: LayerCollectorContextImmutable) :
    LayerWithBorderLineContextImmutable(parent), PointRangeContextInterface {
    override val innerPoint: InnerPointSubContextImmutable =
        InnerPointSubContextImmutable(this)
    override val innerLine: InnerLineSubContextImmutable =
        InnerLineSubContextImmutable(this)
}

@PlotDslMarker
public class PointRangeContextMutable(parent: LayerCollectorContextMutable) : LayerWithBorderLineContextMutable(parent),
    PointRangeContextInterface {
    override val innerPoint: InnerPointSubContextMutable =
        InnerPointSubContextMutable(this)
    override val innerLine: InnerLineSubContextMutable =
        InnerLineSubContextMutable(this)

}

public inline fun LayerCollectorContextImmutable.pointRange(block: PointRangeContextImmutable.() -> Unit) {
    addLayer(PointRangeContextImmutable(this).apply(block), POINT_RANGE)
}

public inline fun LayerCollectorContextMutable.pointRange(block: PointRangeContextMutable.() -> Unit) {
    addLayer(PointRangeContextMutable(this).apply(block), POINT_RANGE)
}

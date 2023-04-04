package org.jetbrains.kotlinx.ggdsl.letsplot.layers.context

import org.jetbrains.kotlinx.ggdsl.dsl.internal.BindingContext
import org.jetbrains.kotlinx.ggdsl.dsl.internal.LayerCollectorContext
import org.jetbrains.kotlinx.ggdsl.dsl.internal.LayerContext
import org.jetbrains.kotlinx.ggdsl.dsl.internal.SubBindingContext
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.context.aes.*
import org.jetbrains.kotlinx.ggdsl.util.context.SelfInvocationContext


public class FontContext internal constructor(override val parentContext: BindingContext):
    SelfInvocationContext, SubBindingContext, WithColor, WithSize, WithFace, WithFamily

public class TextContext(parent: LayerCollectorContext)
    :LayerContext(parent), WithX, WithY, WithAlpha,WithLabel

/*
import org.jetbrains.kotlinx.ggdsl.dsl.internal.*
import org.jetbrains.kotlinx.ggdsl.letsplot.internal.*
import org.jetbrains.kotlinx.ggdsl.util.context.SelfInvocationContext

public interface FontSubContextInterface : SelfInvocationContext {
    public val parentContext: BindingContext
    public val color: ColorAes get() = ColorAes(parentContext)
    public val size: SizeAes get() = SizeAes(parentContext)
    public val family: FontFamilyAes get() = FontFamilyAes(parentContext)
    public val face: FontFaceAes get() = FontFaceAes(parentContext)
}

public class FontSubContextImmutable(override val parentContext: BindingContext) : FontSubContextInterface
public class FontSubContextMutable(override val parentContext: TableBindingContextInterfaceMutable) :
    FontSubContextInterface, TableSubContextMutable(parentContext, false, false)

public interface TextContextInterface : BindingContext {
    public val x: XAes get() = XAes(this)
    public val y: YAes get() = YAes(this)
    public val label: LabelAes get() = LabelAes(this)

    public val alpha: AlphaAes get() = AlphaAes(this)
    public val angle: AngleAes get() = AngleAes(this)
    public val format: FormatAes get() = FormatAes(this)
    public val horizontalJustification: HorizontalJustificationAes get() = HorizontalJustificationAes(this)
    public val verticalJustification: VerticalJustificationAes get() = VerticalJustificationAes(this)

    public val font: FontSubContextInterface
}

*/
/*@PlotDslMarker*//*

public class TextContextImmutable(parent: LayerCollectorContextImmutable) : LayerContextImmutable(parent),
    TextContextInterface {
    override val font: FontSubContextImmutable = FontSubContextImmutable(this)
}

*/
/*@PlotDslMarker*//*

public class TextContextMutable(parent: LayerCollectorContextMutable) :
    LayerContextMutable(parent), TextContextInterface {
    override val font: FontSubContextMutable = FontSubContextMutable(this)
}*/

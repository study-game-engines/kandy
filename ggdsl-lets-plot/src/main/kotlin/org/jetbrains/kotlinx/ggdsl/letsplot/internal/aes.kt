/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.letsplot.internal

import org.jetbrains.kotlinx.ggdsl.ir.aes.AesName


internal val X: AesName = AesName("x")

@PublishedApi
internal val Y: AesName = AesName("y")

internal val Z: AesName = AesName("z")

internal val COLOR: AesName = AesName("color")

internal val FILL: AesName = AesName("fill")

internal val SHAPE: AesName = AesName("shape")

internal val SIZE: AesName = AesName("size")

internal val WIDTH: AesName = AesName("width")

internal val HEIGHT: AesName = AesName("height")

internal val ALPHA: AesName = AesName("alpha")

internal val LINE_TYPE: AesName = AesName("linetype")

internal val LOWER = AesName("lower")

internal val UPPER = AesName("upper")

internal val MIDDLE = AesName("middle")

internal val Y_MIN = AesName("ymin")

internal val Y_MAX = AesName("ymax")

internal val X_MIN = AesName("xmin")

internal val X_MAX = AesName("xmax")

internal val FATTEN = AesName("fatten")

internal val SLOPE: AesName = AesName("slope")

internal val INTERCEPT: AesName = AesName("intercept")

internal val Y_BEGIN = AesName("y")

internal val Y_END = AesName("yend")

internal val X_BEGIN = AesName("x")

internal val X_END = AesName("xend")

internal val LABEL = AesName("label")

internal val FONT_FACE = AesName("fontface")

internal val FONT_FAMILY = AesName("family")

/*

internal val X_END = AesName("xend")

internal val Y_END = AesName("yend")

public val SLOPE: AesName = AesName("slope")

public val INTERCEPT: AesName = AesName("intercept")

internal val COLOR = AesName("color")

public class ColorAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Color> {
    override val name: AesName = COLOR
}

internal val FILL = AesName("fill")

public class FillAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Color> {
    override val name: AesName = FILL
}

public val SHAPE: AesName = AesName("shape")

public class ShapeAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Symbol> {
    override val name: AesName = SHAPE
}

internal val LINE_TYPE = AesName("linetype")

public class LineTypeAes internal constructor(override val context: BindingContext) :
    ScalableNonPositionalAes<LineType> {
    override val name: AesName = LINE_TYPE
}

internal val SIZE = AesName("size")

public class SizeAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Double> {
    override val name: AesName = SIZE
}

internal val STROKE = AesName("stroke")

public class StrokeAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Double> {
    override val name: AesName = STROKE
}

internal val WIDTH = AesName("width")

public class WidthAes internal constructor(override val context: BindingContext) : NonScalableNonPositionalAes<Double> {
    override val name: AesName = WIDTH
}

internal val ALPHA = AesName("alpha")

public class AlphaAes internal constructor(override val context: BindingContext) : ScalableNonPositionalAes<Double> {
    override val name: AesName = ALPHA
}

internal val FATTEN = AesName("fatten")

public class FattenAes internal constructor(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = FATTEN
}

/*
internal val BINS = AesName("bins")

public class BinsAes internal constructor(override val context: BindingContext) : NonPositionalAes<Int> {
    override val name: AesName = BINS
}

internal val BIN_WIDTH = AesName("binwidth")

public class BinWidthAes internal constructor(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = BIN_WIDTH
}

internal val BINS_2D = AesName("bins")

public class Bins2DAes internal constructor(override val context: BindingContext) : NonPositionalAes<Pair<Int, Int>> {
    override val name: AesName = BINS_2D
}

internal val BIN_WIDTH_2D = AesName("binwidth")

public class BinWidth2DAes internal constructor(override val context: BindingContext) :
    NonPositionalAes<Pair<Double, Double>> {
    override val name: AesName = BIN_WIDTH_2D
}

internal val CENTER = AesName("center")

public class CenterAes internal constructor(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = CENTER
}


internal val BOUNDARY = AesName("boundary")

public class BoundaryAes internal constructor(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = BOUNDARY
}

internal val DROP = AesName("drop")

public class DropAes internal constructor(override val context: BindingContext) : NonPositionalAes<Boolean> {
    override val name: AesName = DROP
}

public val OUTLIER_COLOR: AesName = AesName(Option.Geom.BoxplotOutlier.COLOR)

public data class OutlierColorAes(override val context: BindingContext) : NonPositionalAes<Color> {
    override val name: AesName = OUTLIER_COLOR
}

public val OUTLIER_FILL: AesName = AesName(Option.Geom.BoxplotOutlier.FILL)

public data class OutlierFillAes(override val context: BindingContext) : NonPositionalAes<Color> {
    override val name: AesName = OUTLIER_FILL
}

public val OUTLIER_SHAPE: AesName = AesName(Option.Geom.BoxplotOutlier.SHAPE)

public data class OutlierShapeAes(override val context: BindingContext) : NonPositionalAes<Symbol> {
    override val name: AesName = OUTLIER_SHAPE
}

public val OUTLIER_SIZE: AesName = AesName(Option.Geom.BoxplotOutlier.SIZE)

public data class OutlierSizeAes(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = OUTLIER_SIZE
}

internal val VAR_WIDTH = AesName("varwidth")

public class VarWidthAes internal constructor(override val context: BindingContext) : NonPositionalAes<Boolean> {
    override val name: AesName = VAR_WIDTH
}


public val BAND_WIDTH: AesName = AesName("bw")

public data class BWAes(override val context: BindingContext) : NonPositionalAes<BandWidth> {
    override val name: AesName = BAND_WIDTH
}


public val KERNEL: AesName = AesName("kernel")

public data class KernelAes(override val context: BindingContext) : NonPositionalAes<Kernel> {
    override val name: AesName = KERNEL
}

public val NUMBER: AesName = AesName("n")

public data class NumberAes(override val context: BindingContext) : NonPositionalAes<Int> {
    override val name: AesName = NUMBER
}

public val TRIM: AesName = AesName("trim")

public data class TrimAes(override val context: BindingContext) : NonPositionalAes<Boolean> {
    override val name: AesName = TRIM
}

public val ADJUST: AesName = AesName("adjust")

public data class AdjustAes(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = ADJUST
}

public val FULL_SCAN_MAX: AesName = AesName("fs_max")

public data class FullScanMaxAes(override val context: BindingContext) : NonPositionalAes<Int> {
    override val name: AesName = FULL_SCAN_MAX
}


public val DISTRIBUTION: AesName = AesName(Option.Stat.QQ.DISTRIBUTION)

public data class DistributionAes(override val context: BindingContext) : NonPositionalAes<String> {
    override val name: AesName = DISTRIBUTION
}

public val D_PARAMS: AesName = AesName(Option.Stat.QQ.DISTRIBUTION_PARAMETERS)

public data class DParamsAes(override val context: BindingContext) : NonPositionalAes<List<Number>> {
    override val name: AesName = D_PARAMS
}

public val SAMPLE: AesName = AesName("sample")

public class SampleAes(override val context: BindingContext) : ScalablePositionalAes {
    override val name: AesName = SAMPLE
}

public class SampleDummyAes(override val context: BindingContext) : ScalablePositionalAes {
    override val name: AesName = SAMPLE
}

public val QUANTILES: AesName = AesName("quantiles")

public data class QuantilesAes(override val context: BindingContext) : NonPositionalAes<Pair<Double, Double>> {
    override val name: AesName = QUANTILES
}

public val METHOD: AesName = AesName("method")

public data class MethodAes(override val context: BindingContext) : NonPositionalAes<String> {
    override val name: AesName = METHOD
}

public val SE: AesName = AesName("se")

public data class SEAes(override val context: BindingContext) : NonPositionalAes<Boolean> {
    override val name: AesName = SE
}

public val LEVEL: AesName = AesName("level")

public data class LevelAes(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = LEVEL
}

public val SPAN: AesName = AesName("span")

public data class SpanAes(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = SPAN
}

public val DEG: AesName = AesName("deg")

public data class DegAes(override val context: BindingContext) : NonPositionalAes<Int> {
    override val name: AesName = DEG
}

public val SEED: AesName = AesName("seed")

public data class SeedAes(override val context: BindingContext) : NonPositionalAes<Long> {
    override val name: AesName = SEED
}

public val MAX_N: AesName = AesName("max_n")

public data class MaxNAes(override val context: BindingContext) : NonPositionalAes<Int> {
    override val name: AesName = MAX_N
}

public val VIOLIN_WIDTH: AesName = AesName("violinwidth")

public data class ViolinWidthAes(override val context: BindingContext) : NonPositionalAes<Double> {
    override val name: AesName = VIOLIN_WIDTH
}

public val VIOLIN_SCALE: AesName = AesName("scale")

public data class ViolinScaleAes(override val context: BindingContext) : NonPositionalAes<String> {
    override val name: AesName = VIOLIN_SCALE
}

public val DRAW_QUANTILES: AesName = AesName("draw_quantiles")

public data class DrawQuantilesAes(override val context: BindingContext) : NonPositionalAes<List<Double>> {
    override val name: AesName = DRAW_QUANTILES
}

 */

internal val LABEL = AesName("label")

public data class LabelAes internal constructor(override val context: BindingContext) :
    ScalableNonPositionalAes<String> {
    override val name: AesName = LABEL
}

internal val FONT_FACE = AesName("fontface")

public data class FontFaceAes internal constructor(override val context: BindingContext) :
    ScalableNonPositionalAes<FontFace> {
    override val name: AesName = FONT_FACE
}

internal val FONT_FAMILY = AesName("family")

public data class FontFamilyAes internal constructor(override val context: BindingContext) :
    ScalableNonPositionalAes<FontFamily> {
    override val name: AesName = FONT_FAMILY
}

internal val ANGLE = AesName("angle")

public data class AngleAes internal constructor(override val context: BindingContext) :
    ScalableNonPositionalAes<Double> {
    override val name: AesName = ANGLE
}

internal val LABEL_FORMAT = AesName(Option.Geom.Text.LABEL_FORMAT)

public data class FormatAes internal constructor(override val context: BindingContext) :
    NonPositionalAes<String> {
    override val name: AesName = LABEL_FORMAT
}


internal val HORIZONTAL_JUSTIFICATION = AesName("hjust")

public data class HorizontalJustificationAes internal constructor(override val context: BindingContext) :
    NonPositionalAes<HorizontalJustification> {
    override val name: AesName = HORIZONTAL_JUSTIFICATION
}

internal val VERTICAL_JUSTIFICATION = AesName("vjust")

public data class VerticalJustificationAes internal constructor(override val context: BindingContext) :
    NonPositionalAes<VerticalJustification> {
    override val name: AesName = VERTICAL_JUSTIFICATION
}

public val X_INTERCEPT: AesName = AesName("xintercept")

// TODO
public class XInterceptAes(override val context: BindingContext) : NonScalablePositionalAes {
    override val name: AesName = X_INTERCEPT
}

public val Y_INTERCEPT: AesName = AesName("yintercept")

// TODO
public class YInterceptAes(override val context: BindingContext) : NonScalablePositionalAes {
    override val name: AesName = Y_INTERCEPT
}

 */

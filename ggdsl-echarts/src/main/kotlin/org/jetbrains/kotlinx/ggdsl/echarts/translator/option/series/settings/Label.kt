package org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.ggdsl.echarts.features.label.LabelFeature
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.EchartsColor
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.toEchartsColor
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.LayerFeature

internal fun Map<FeatureName, LayerFeature>.getLabel(): Label? {
    return (this[LabelFeature.FEATURE_NAME] as? LabelFeature)?.let {
        Label(
            show = true,
            position = it.position?.name,
            distance = it.position?.distance,
            rotate = it.position?.rotate,
            formatter = it.formatter,
            color = it.textStyle?.color?.toEchartsColor(),
            fontStyle = it.textStyle?.fontStyle?.style,
            fontWeight = it.textStyle?.fontWeight?.weight,
            fontFamily = it.textStyle?.fontFamily?.family,
            fontSize = it.textStyle?.fontSize,
            lineHeight = it.textStyle?.lineHeight,
            width = it.textStyle?.width,
            height = it.textStyle?.height,
            textBorderColor = it.textStyle?.textBorderColor?.toEchartsColor(),
            textBorderWidth = it.textStyle?.textBorderWidth,
            textBorderType = it.textStyle?.textBorderType?.type,
            borderColor = it.border?.color?.toEchartsColor(),
            borderWidth = it.border?.width,
            borderType = it.border?.type?.type,
            borderRadius = it.border?.radius,
        )
    }
}

@Serializable
internal data class Label(
    val show: Boolean? = null,
    val position: String? = null, // TODO (string array)
    val distance: Int? = null,
    val rotate: Int? = null,
    val offset: Pair<String, String>? = null,
    val formatter: String? = null,
    val color: EchartsColor? = null,
    val fontStyle: String? = null, // TODO (Font style)
    val fontWeight: String? = null, // TODO (FontSeight)
    val fontFamily: String? = null,
    val fontSize: Int? = null,
    val align: String? = null, // TODO (align)
    val verticalAlign: String? = null, // TODO(vertical align)
    val lineHeight: Int? = null,
    val backgroundColor: EchartsColor? = null,
    val borderColor: EchartsColor? = null,
    val borderWidth: Double? = null,
    val borderType: String? = null, // TODO (BorderType)
    val borderDashOffset: Int? = null,
    val borderRadius: Double? = null,
    val padding: Int? = null,
    val shadowColor: EchartsColor? = null,
    val shadowBlur: Int? = null,
    val shadowOffsetX: Int? = null,
    val shadowOffsetY: Int? = null,
    val width: Int? = null,
    val height: Int? = null,
    val textBorderColor: EchartsColor? = null,
    val textBorderWidth: Int? = null,
    val textBorderType: String? = null, // TODO (TextDorderType)
    val textBorderDashOffset: Int? = null,
    val textShadowColor: EchartsColor? = null,
    val textShadowBlur: Int? = null,
    val textShadowOffsetX: Int? = null,
    val textShadowOffsetY: Int? = null,
    val overflow: String? = null, // TODO(Overflow)
    val ellipsis: String? = null,
    val rich: String? = null, // TODO
    val valueAnimation: Boolean? = null // TODO need only for end label 
)
package org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.ggdsl.echarts.features.animation.AnimationLineFeature
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.*
import org.jetbrains.kotlinx.ggdsl.echarts.translator.option.series.settings.marks.*
import org.jetbrains.kotlinx.ggdsl.ir.Layer

internal fun Layer.toBoxplotSeries(name: String?, encode: Encode?): BoxplotSeries {
    val animation = (features[AnimationLineFeature.FEATURE_NAME] as? AnimationLineFeature)

    return BoxplotSeries(
        name = name,
        encode = encode,
        markPoint = features.getEchartsMarkPoint(),
        markLine = features.getEchartsMarkLine(),
        markArea = features.getEchartsMarkArea(),
        animationDuration = animation?.duration,
        animationEasing = animation?.easing?.name,
        animationDelay = animation?.delay,
    )
}

@Serializable
internal class BoxplotSeries(
    override val type: String = "boxplot",
    override val id: String? = null,
    override val coordinateSystem: CoordinateSystem? = null,
    val xAxisIndex: Int? = null,
    val yAxisIndex: Int? = null,
    override val name: String? = null,
    override val colorBy: String? = null,
    override val legendHoverLink: Boolean? = null,
    val hoverAnimation: Boolean? = null,
    val layout: String? = null,
    val boxWidth: Pair<String, String>? = null,
    override val itemStyle: ItemStyle? = null,
    override val emphasis: Emphasis? = null,
    override val blur: Blur? = null,
    override val select: Select? = null,
    override val selectedMode: String? = null,
    override val dimensions: List<Dimension>? = null,
    override val encode: Encode? = null,
    override val dataGroupId: String? = null,
    override val data: List<List<String>>? = null,
    override val markPoint: EchartsMarkPoint? = null,
    override val markLine: EchartsMarkLine? = null,
    override val markArea: EchartsMarkArea? = null,
    override val zlevel: Int? = null,
    override val z: Int? = null,
    override val silent: Boolean? = null,
    override val animationDuration: Int? = null,
    override val animationEasing: String? = null,
    override val animationDelay: Int? = null,
    override val universalTransition: UniversalTransition? = null,
    override val tooltip: Tooltip? = null
) : Series()
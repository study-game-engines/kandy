package org.jetbrains.kotlinx.ggdsl.echarts.translator.option

import kotlinx.serialization.Serializable

@Serializable
internal data class Legend(
    val type: String? = null,
    val id: String? = null,
    val show: Boolean? = null,
    val zlevel: Int? = null,
    val z: Int? = null,
    val left: Int? = null, // string number
    val top: Int? = null,
    val right: Int? = null,
    val bottom: Int? = null,
    val width: Int? = null, // string number
    val height: Int? = null,
    val orient: String? = null,
    val align: String? = null, // 'auto', 'left', 'right'
    val padding: Int? = null, // number array
    val itemGap: Int? = null,
    val itemWidth: Int? = null,
    val itemHeight: Int? = null,
//    val itemStyle: ItemStyle?,
//    val lineStyle: LineStyle?,
    val symbolRotate: Int? = null, // number string
    val formatter: String? = null,
    val selectedMode: String? = null, // boolean string
    val inactiveColor: EchartsColor? = null,
    val inactiveBorderColor: EchartsColor? = null,
    val inactiveBorderWidth: EchartsColor? = null,
    val selected: Map<String, Boolean>? = null, // таблица состояний для серий
//    val textStyle: TextStyle?,
//    val tooltip: Tooltip?,
    val icon: String? = null,
//    val data: List<LegendData>?,
    val backgroundColor: EchartsColor? = null,
    val borderColor: EchartsColor? = null,
    val borderRadius: Int? = null, // number Array
    val shadowBlur: Int? = null,
    val shadowColor: EchartsColor? = null,
    val shadowOffsetX: Int? = null,
    val shadowOffsetY: Int? = null, // This property works only if show: true configured.
    val scrollDataIndex: Int? = null,
    val pageButtonItemGap: Int? = null,
    val pageButtonGap: Int? = null,
    val pageButtonPosition: String? = null, // Start End
    val pageFormatter: Int? = null,
    val pageIcons: List<String>? = null,
    val pageIconColor: String? = null,
    val pageIconInactiveColor: String? = null,
    val pageIconSize: Int? = null,
//    val pageTextStyle: TextStyle?,
    val animation: Boolean? = null,
    val animationDurationUpdate: Int? = null,
//    val emphasis: Object<SelectorLabel>?,
    val selector: String? = null,
//    val selectorLabel: SelectorLabel?,
    val selectorPosition: String? = null,
    val selectorItemGap: Int? = null,
    val selectorButtonGap: Int? = null
)
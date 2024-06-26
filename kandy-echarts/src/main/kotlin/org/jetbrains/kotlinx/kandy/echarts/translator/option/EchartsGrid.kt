/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.echarts.translator.option

import kotlinx.serialization.Serializable
import org.jetbrains.kotlinx.kandy.echarts.settings.SizeUnit
import org.jetbrains.kotlinx.kandy.echarts.translator.option.series.settings.EchartsTooltip

@Serializable
internal data class EchartsGrid(
    val id: String? = null,
    val show: Boolean? = null,
    val zlevel: Int? = null,
    val z: Int? = null,
    val left: SizeUnit? = null,
    val top: SizeUnit? = null,
    val right: SizeUnit? = null,
    val bottom: SizeUnit? = null,
    val width: SizeUnit? = null,
    val height: SizeUnit? = null,
    val containLabel: Boolean? = null,
    val backgroundColor: EchartsColor? = null,
    val borderColor: EchartsColor? = null,
    val borderWidth: Int? = null,
    val shadowBlur: Int? = null,
    val shadowColor: EchartsColor? = null,
    val shadowOffsetX: Int? = null,
    val shadowOffsetY: Int? = null,
    val tooltip: EchartsTooltip? = null
)

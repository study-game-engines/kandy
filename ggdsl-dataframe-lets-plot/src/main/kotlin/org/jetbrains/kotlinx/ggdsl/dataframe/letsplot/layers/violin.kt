/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.dataframe.letsplot.layers

import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.dataframe.toDataSource
import org.jetbrains.kotlinx.ggdsl.dsl.PlotContext
import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.ViolinContext
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.stat.ViolinScale
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.violin
import org.jetbrains.kotlinx.ggdsl.letsplot.util.statParameters.BandWidth
import org.jetbrains.kotlinx.ggdsl.letsplot.util.statParameters.Kernel

public inline fun <reified T : Any, reified R : Any> PlotContext.violin(
    sourceX: ColumnReference<T>,
    sourceY: DataSource<R>,
    drawQuantiles: List<Double>? = null,
    scale: ViolinScale? = null,
    kernel: Kernel? = null,
    bandWidth: BandWidth? = null,
    pointsSampled: Int? = null,
    trim: Boolean? = null,
    adjust: Double? = null,
    fullScanMax: Int? = null,
    block: ViolinContext.() -> Unit,
): Unit = violin(
    sourceX.toDataSource(),
    sourceY, drawQuantiles, scale, kernel, bandWidth, pointsSampled, trim, adjust, fullScanMax, block
)

public inline fun <reified T : Any> PlotContext.violin(
    sourceY: ColumnReference<T>,
    drawQuantiles: List<Double>? = null,
    scale: ViolinScale? = null,
    kernel: Kernel? = null,
    bandWidth: BandWidth? = null,
    pointsSampled: Int? = null,
    trim: Boolean? = null,
    adjust: Double? = null,
    fullScanMax: Int? = null,
    block: ViolinContext.() -> Unit,
): Unit = violin(
    sourceY.toDataSource(), drawQuantiles, scale, kernel, bandWidth, pointsSampled, trim, adjust, fullScanMax, block
)


public inline fun <reified T : Any, reified R : Any> PlotContext.violin(
    sourceX: DataSource<T>,
    sourceY: ColumnReference<R>,
    drawQuantiles: List<Double>? = null,
    scale: ViolinScale? = null,
    kernel: Kernel? = null,
    bandWidth: BandWidth? = null,
    pointsSampled: Int? = null,
    trim: Boolean? = null,
    adjust: Double? = null,
    fullScanMax: Int? = null,
    block: ViolinContext.() -> Unit,
): Unit = violin(
    sourceX,
    sourceY.toDataSource(),
    drawQuantiles, scale, kernel, bandWidth, pointsSampled, trim, adjust, fullScanMax, block
)

public inline fun <reified T : Any, reified R : Any> PlotContext.violin(
    sourceX: ColumnReference<T>,
    sourceY: ColumnReference<R>,
    drawQuantiles: List<Double>? = null,
    scale: ViolinScale? = null,
    kernel: Kernel? = null,
    bandWidth: BandWidth? = null,
    pointsSampled: Int? = null,
    trim: Boolean? = null,
    adjust: Double? = null,
    fullScanMax: Int? = null,
    block: ViolinContext.() -> Unit,
): Unit = violin(
    sourceX.toDataSource(),
    sourceY.toDataSource(),
    drawQuantiles, scale, kernel, bandWidth, pointsSampled, trim, adjust, fullScanMax, block
)
/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.dataframe.letsplot.layers


import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.dataframe.toDataSource
import org.jetbrains.kotlinx.ggdsl.dsl.PlotContext
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.QQLineContext
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.qqLine
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.stat.Distribution

inline fun <reified T : Any> PlotContext.qqLine(
    source: ColumnReference<T>,
    distribution: Distribution? = null,
    quantiles: Pair<Double, Double>? = null,
    block: QQLineContext.() -> Unit
) = qqLine(source.toDataSource(), distribution, quantiles, block)

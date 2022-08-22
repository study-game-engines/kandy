package org.jetbrains.kotlinx.ggdsl.dataframe.letsplot

import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.dsl.LayerContext
import org.jetbrains.kotlinx.ggdsl.ir.aes.Aes
import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import org.jetbrains.kotlinx.ggdsl.letsplot.layers.stat.Stat
import org.jetbrains.kotlinx.ggdsl.letsplot.tooltips.Anchor
import org.jetbrains.kotlinx.ggdsl.letsplot.tooltips.LayerTooltips
import org.jetbrains.kotlinx.ggdsl.letsplot.tooltips.LayerTooltipsContext

/**
 * Inserts value of given column into format string.
 *
 * @param column column whose value will be inserted into the tooltip
 * @return format string
 */
fun value(column: ColumnReference<*>): String {
    return "@${column.name()}"
}

/**
 * Adds standard line for given column
 * (name of this column on the left side and corresponding value on the right side).
 *
 * @param column
 */
fun LayerTooltipsContext.line(column: ColumnReference<*>) {
    lineBuffer.add("@|@${column.name()}")
}

fun LayerContext.tooltips(
    variablesDS: List<DataSource<*>> = listOf(),
    columns: List<ColumnReference<*>> = listOf(),
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    hide: Boolean = false,
    dsFormats: Map<DataSource<*>, String> = mapOf(),
    columnsFormats: Map<ColumnReference<*>, String> = mapOf(),
) {
    features[LayerTooltips.FEATURE_NAME] = LayerTooltips.fromVariables(
        variablesDS.map { it.id } + columns.map { it.name() },
        title,
        anchor,
        minWidth,
        hide,
        dsFormats.map { it.key.id to it.value }
                + columnsFormats.map { it.key.name() to it.value },
    )
}

inline fun LayerContext.tooltips(
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    hide: Boolean = false,
    dsFormats: Map<DataSource<*>, String> = mapOf(),
    columnsFormats: Map<ColumnReference<*>, String> = mapOf(),
    aesFormats: Map<Aes, String> = mapOf(),
    statFormats: Map<Stat<*>, String> = mapOf(),
    tooltipsContextAction: LayerTooltipsContext.() -> Unit
) {
    features[LayerTooltips.FEATURE_NAME] = LayerTooltips.fromContext(
        title,
        anchor,
        minWidth,
        hide,
        dsFormats.map { it.key.id to it.value }
                + columnsFormats.map { it.key.name() to it.value }
                + aesFormats.map { it.key.name.name to it.value }
                + statFormats.map { it.key.name to it.value },
        LayerTooltipsContext().apply(tooltipsContextAction)
    )
}
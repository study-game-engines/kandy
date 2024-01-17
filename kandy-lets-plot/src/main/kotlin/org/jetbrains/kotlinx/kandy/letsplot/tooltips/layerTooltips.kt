/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.letsplot.tooltips

import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.kandy.dsl.internal.*
import org.jetbrains.kotlinx.kandy.letsplot.tooltips.context.LayerTooltipsContext
import org.jetbrains.kotlinx.kandy.letsplot.tooltips.feature.LayerTooltips
import kotlin.reflect.KProperty


/**
 * Inserts value of given column into formatted string.
 *
 * @param column column whose value will be inserted into the tooltip
 * @return formatted string
 */
public fun LayerContextInterface.value(column: ColumnReference<*>): String {
    @Suppress("invisible_reference")
    return "@${datasetHandler.addColumn(column)}"
}

/**
 * Inserts value of given column into formatted string.
 *
 * @param columnName name of column whose value will be inserted into the tooltip
 * @return formatted string
 */
public fun LayerContextInterface.value(columnName: String): String {
    @Suppress("invisible_reference")
    return "@${datasetHandler.takeColumn(columnName)}"
}

/**
 * Inserts value of given column into formatted string.
 *
 * @param column name of column whose value will be inserted into the tooltip
 * @return formatted string
 */
public fun LayerContextInterface.value(column: KProperty<*>): String {
    @Suppress("invisible_reference")
    return "@${datasetHandler.takeColumn(column.name)}"
}

/**
 * Hides tooltips.
 *
 * @param hide flag of tooltips displaying.
 */
public fun LayerContextInterface.tooltips(
    enable: Boolean = true,
    enableSideTooltips: Boolean = false
) {
    layerFeatures[LayerTooltips.FEATURE_NAME] = LayerTooltips(
        listOf(),
        null,
        listOf(),
        null, null, null,
        enable, enableSideTooltips
    )
}

/**
 * Defines the tooltips format for this layer.
 *
 * Creates a [LayerTooltipsContext]. In this context, you can configure lines of tooltip
 * by using line(…) methods.
 *
 * @see [LayerTooltipsContext].
 *
 * @param variables list of columns to create a general multiline tooltip with.
 * Useful for specifying the tooltip content quickly, instead of configuring it via the line(…) methods.
 * @param title the string template to use as a title in the multi-line tooltip.
 * @param anchor the fixed position for the general tooltip.
 * @param minWidth minimum width of a general tooltip in pixels.
 * @param hide flag of tooltips displaying.
 * @param formats map of columns to format string of its value.
 * @see value
 */
public inline fun LayerContextInterface.tooltips(
    vararg variables: ColumnReference<*>,
    formats: Map<ColumnReference<*>, String> = mapOf(),
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    enableSideTooltips: Boolean = false,
    tooltipsContextAction: LayerTooltipsContext.() -> Unit
) {
    @Suppress("invisible_reference")
    layerFeatures[LayerTooltips.FEATURE_NAME] = LayerTooltips.fromContext(
        variables.map { datasetHandler.addColumn(it) },
        title,
        anchor,
        minWidth,
        true,
        enableSideTooltips,
        formats.map { (column, format) -> datasetHandler.takeColumn(column.name()) to format },
        LayerTooltipsContext(this).apply(tooltipsContextAction)
    )
}

/**
 * Defines the tooltips format for this layer.
 *
 * @param variables list of column names to create a general multiline tooltip with.
 * @param formats map of columns to format string of its value.
 * @param title the string template to use as a title in the multi-line tooltip.
 * @param anchor the fixed position for the general tooltip.
 * @param minWidth minimum width of a general tooltip in pixels.
 * @param hide flag of tooltips displaying.
 * @see value
 */
public fun LayerContextInterface.tooltips(
    variable: String,
    vararg variables: String,
    formats: Map<String, String> = mapOf(),
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    enableSideTooltips: Boolean = false
) {
    @Suppress("invisible_reference")
    layerFeatures[LayerTooltips.FEATURE_NAME] = LayerTooltips(
        (listOf(variable) + variables.toList()).map { datasetHandler.takeColumn(it) },
        null,
        formats.toList(),
        title, anchor, minWidth, true, enableSideTooltips
    )
}

/**
 * Defines the tooltips format for this layer.
 *
 * @param variables list of columns to create a general multiline tooltip with.
 * @param formats map of columns to format string of its value.
 * @param title the string template to use as a title in the multi-line tooltip.
 * @param anchor the fixed position for the general tooltip.
 * @param minWidth minimum width of a general tooltip in pixels.
 * @param hide flag of tooltips displaying.
 * @see value
 */
public fun LayerContextInterface.tooltips(
    variable: ColumnReference<*>,
    vararg variables: ColumnReference<*>,
    formats: Map<ColumnReference<*>, String> = mapOf(),
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    enableSideTooltips: Boolean = false
) {
    @Suppress("invisible_reference")
    layerFeatures[LayerTooltips.FEATURE_NAME] = LayerTooltips(
        (listOf(variable) + variables.toList()).map { datasetHandler.addColumn(it) },
        null,
        formats.map { (column, format) -> datasetHandler.takeColumn(column.name()) to format },
        title,
        anchor,
        minWidth,
        true,
        enableSideTooltips
    )
}


/**
 * Defines the tooltips format for this layer.
 *
 * @param variables list of column names to create a general multiline tooltip with.
 * @param formats map of columns to format string of its value.
 * @param title the string template to use as a title in the multi-line tooltip.
 * @param anchor the fixed position for the general tooltip.
 * @param minWidth minimum width of a general tooltip in pixels.
 * @param hide flag of tooltips displaying.
 * @see value
 */
public fun LayerContextInterface.tooltips(
    variable:KProperty<*>,
    vararg variables: KProperty<*>,
    formats: Map<KProperty<*>, String> = mapOf(),
    title: String? = null,
    anchor: Anchor? = null,
    minWidth: Double? = null,
    enableSideTooltips: Boolean = false
) {
    @Suppress("invisible_reference")
    layerFeatures[LayerTooltips.FEATURE_NAME] = LayerTooltips(
        (listOf(variable) + variables.toList()).map { datasetHandler.takeColumn(it.name) },
        null,
        formats.map { (property, format) ->  datasetHandler.takeColumn(property.name) to format },
        title, anchor, minWidth, true, enableSideTooltips
    )
}

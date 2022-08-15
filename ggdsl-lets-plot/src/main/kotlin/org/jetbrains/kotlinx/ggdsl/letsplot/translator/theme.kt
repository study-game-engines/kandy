package org.jetbrains.kotlinx.ggdsl.letsplot.translator

import org.jetbrains.kotlinx.ggdsl.letsplot.theme.*
import org.jetbrains.kotlinx.ggdsl.util.color.StandardColor
import org.jetbrains.letsPlot.intern.OptionsMap
import org.jetbrains.letsPlot.themes.*

fun LineParameters.wrap(): Map<String, Any> {
    return elementLine(
        (color as? StandardColor)?.description,
        width, blank
    )
}

fun BackgroundParameters.wrap(): Map<String, Any> {
    return elementRect(
        (fillColor as? StandardColor)?.description,
        (borderLineColor as? StandardColor)?.description,
        borderLineWidth, blank
    )
}

fun TextParameters.wrap(): Map<String, Any> {
    return elementText(
        (color as? StandardColor)?.description,
        font?.toString(),
        blank
    )
}

fun CustomTheme.wrap(): theme {
    return theme(
        line = global.line.wrap(),
        rect = global.background.wrap(),
        text = global.text.wrap(),// TODO
        title = null,// TODO
        axis = null,//TODO
        axisOntop = axis.onTop,
        axisOntopX = xAxis.onTop,
        axisOntopY = yAxis.onTop,
        axisTitle = axis.title.wrap(),
        axisTitleX = xAxis.title.wrap(),
        axisTitleY = yAxis.title.wrap(),
        axisText = axis.text.wrap(),
        axisTextX = xAxis.text.wrap(),
        axisTextY = yAxis.text.wrap(),
        axisTicks = axis.ticks.wrap(),
        axisTicksX = xAxis.ticks.wrap(),
        axisTicksY = yAxis.ticks.wrap(),
        axisTicksLength = axis.ticksLength,
        axisTicksLengthX = xAxis.ticksLength,
        axisTicksLengthY = yAxis.ticksLength,
        axisLine = axis.line.wrap(),
        axisLineX = xAxis.line.wrap(),
        axisLineY = yAxis.line.wrap(),
        legendBackground = legend.background.wrap(),
        legendText = legend.text.wrap(),
        legendTitle = legend.title.wrap(),
        panelBackground = panel.background.wrap(),
        panelBorder = panel.borderLine.wrap(),
        panelGrid = panel.grid.lineGlobal.wrap(),
        panelGridMajor = panel.grid.majorLine.wrap(),
        panelGridMajorX = panel.grid.majorXLine.wrap(),
        panelGridMajorY = panel.grid.majorYLine.wrap(),
        panelGridMinor = panel.grid.minorLine.wrap(),
        panelGridMinorX = panel.grid.minorXLine.wrap(),
        panelGridMinorY = panel.grid.minorYLine.wrap(),
        plotBackground = plot.background.wrap(),
        plotCaption = plot.caption.wrap(),
        plotSubtitle = plot.subtitle.wrap(),
        plotTitle = plot.title.wrap(),
        stripBackground = strip.background.wrap(),
        stripText = strip.text.wrap(),
        axisTooltip = axis.tooltip.background.wrap(),
        axisTooltipX = xAxis.tooltip.background.wrap(),
        axisTooltipY = yAxis.tooltip.background.wrap(),
        axisTooltipText = axis.tooltip.text.wrap(),
        axisTooltipTextX = xAxis.tooltip.text.wrap(),
        axisTooltipTextY = yAxis.tooltip.text.wrap(),
        tooltip = layerTooltips.background.wrap(),
        tooltipText = layerTooltips.text.wrap(),
        tooltipTitleText = layerTooltips.title.wrap()
    )
}

fun Theme.wrap(): OptionsMap {
    return when (this) {
        Theme.Grey -> themeGrey()
        Theme.Classic -> themeClassic()
        Theme.Light -> themeLight()
        Theme.Minimal -> themeMinimal()
        Theme.Minimal2 -> themeMinimal2()
        Theme.None -> themeNone()
        is CustomTheme -> this.wrap()
    }
}
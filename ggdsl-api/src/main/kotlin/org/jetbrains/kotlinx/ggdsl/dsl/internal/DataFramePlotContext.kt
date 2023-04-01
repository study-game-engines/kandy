package org.jetbrains.kotlinx.ggdsl.dsl.internal

import org.jetbrains.kotlinx.dataframe.*
import org.jetbrains.kotlinx.dataframe.api.getColumns
import org.jetbrains.kotlinx.dataframe.columns.ColumnReference
import org.jetbrains.kotlinx.ggdsl.ir.Layer
import org.jetbrains.kotlinx.ggdsl.ir.data.GroupedData
import org.jetbrains.kotlinx.ggdsl.ir.data.NamedData
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.PlotFeature

public class DataFramePlotContext<T>(
    private val dataFrame: DataFrame<T>
) : LayerPlotContext, ColumnsContainer<T> by dataFrame {
    override val bindingCollector: BindingCollector = BindingCollector()
    override val layers: MutableList<Layer> = mutableListOf()
    override val plotContext: PlotContext = this
    override val datasetIndex: Int = 0
    override val datasetHandlers: MutableList<DatasetHandler> = mutableListOf(
        DatasetHandler(NamedData(dataFrame))
    )
    override val features: MutableMap<FeatureName, PlotFeature> = mutableMapOf()

    public fun <C> columns(selector: ColumnsSelector<T, C>): List<DataColumn<C>> = dataFrame.get(selector)
    public fun <C> columns(vararg columns: String): List<AnyCol> = dataFrame.getColumns(*columns)

    public inline fun groupBy(
        columns: Iterable<String>,
        block: GroupedContext.() -> Unit
    ) {
        datasetHandlers.add(
            DatasetHandler(
                GroupedData(
                    datasetHandler.initialDataset as NamedData,
                    columns.toList()
                )
            )
        )
        GroupedContext(
            datasetHandlers.size - 1,
            this
        ).apply(block)
    }

    public inline fun groupBy(
        vararg columns: String,
        block: GroupedContext.() -> Unit
    ): Unit = groupBy(columns.toList(), block)

    public inline fun groupBy(
        vararg columnReferences: ColumnReference<*>,
        block: GroupedContext.() -> Unit
    ):  Unit = groupBy(columnReferences.map { it.name() }, block)
}
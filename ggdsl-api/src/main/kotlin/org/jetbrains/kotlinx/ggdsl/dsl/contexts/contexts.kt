/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.dsl.contexts

import org.jetbrains.kotlinx.ggdsl.dsl.PlotDslMarker
import org.jetbrains.kotlinx.ggdsl.dsl.StatDSLMarker
import org.jetbrains.kotlinx.ggdsl.ir.Layer
import org.jetbrains.kotlinx.ggdsl.ir.Plot
import org.jetbrains.kotlinx.ggdsl.ir.aes.AesName
import org.jetbrains.kotlinx.ggdsl.ir.bindings.*
import org.jetbrains.kotlinx.ggdsl.ir.data.ColumnPointer
import org.jetbrains.kotlinx.ggdsl.ir.data.GroupedDataInterface
import org.jetbrains.kotlinx.ggdsl.ir.data.NamedDataInterface
import org.jetbrains.kotlinx.ggdsl.ir.data.TableData
import org.jetbrains.kotlinx.ggdsl.ir.feature.FeatureName
import org.jetbrains.kotlinx.ggdsl.ir.feature.LayerFeature
import org.jetbrains.kotlinx.ggdsl.ir.feature.PlotFeature
import org.jetbrains.kotlinx.ggdsl.ir.geom.Geom
import org.jetbrains.kotlinx.ggdsl.ir.scale.*

/**
 * Internal collector of mappings and settings.
 */
public class BindingCollector internal constructor() {
    public val mappings: MutableMap<AesName, Mapping> = mutableMapOf()
    public val settings: MutableMap<AesName, Setting> = mutableMapOf()

    public val freeScales: MutableMap<AesName, FreeScale> = mutableMapOf()

    internal fun copyFrom(other: BindingCollector) {
        mappings.putAll(other.mappings)
        settings.putAll(other.settings)
    }
}

/**
 * Base class for binding context.
 *
 * In this context, the mechanism of bindings, that is, mappings and settings, is defined.
 * It is implemented with aesthetic attribute properties invocation with a raw or scaled source as an argument.
 *
 * @property data the mutual dataset context.
 */

//@PlotDslMarker


public interface BindingContext {
    // todo hide
    public val bindingCollector: BindingCollector
}


public abstract class SubBindingContext(parentalBindingCollector: BindingCollector?) : BindingContext {
    override val bindingCollector: BindingCollector = BindingCollector().apply {
        parentalBindingCollector?.let {
            copyFrom(it)
        }
    }
}


public interface TableBindingContext : BindingContext {
    public val data: TableData
}


public abstract class SubTableBindingContext(parent: TableBindingContext) : TableBindingContext,
    SubBindingContext(parent.bindingCollector) {
    override val data: TableData = parent.data
}

public interface NameDataBindingContext : TableBindingContext {
    override val data: NamedDataInterface

    public fun groupBy(vararg columnPointers: ColumnPointer<*>, block: WithGroupingBindingContext.() -> Unit)
}


public abstract class LayerContext(parent: LayerCollectorContext) : TableBindingContext,
    SubTableBindingContext(parent) {
    public val features: MutableMap<FeatureName, LayerFeature> = mutableMapOf()

}


public interface LayerCollectorContext : TableBindingContext {
    public val layers: MutableList<Layer>

    // todo hide
    public fun addLayer(context: LayerContext, geom: Geom) {
        layers.add(
            Layer(
                data,
                geom,
                context.bindingCollector.mappings,
                context.bindingCollector.settings,
                context.features,
                context.bindingCollector.freeScales
            )
        )
    }
}

public abstract class SubLayerCollectorContext(parent: LayerCollectorContext) : TableBindingContext,
    LayerCollectorContext,
    SubBindingContext(parent.bindingCollector) {
    override val data: TableData = parent.data
    override val layers: MutableList<Layer> = parent.layers
}

@PlotDslMarker
@StatDSLMarker
public open class WithGroupingBindingContext constructor(
    override val data: GroupedDataInterface,
    override val layers: MutableList<Layer>,
    parentalBindingCollector: BindingCollector?
) : TableBindingContext, LayerCollectorContext, SubBindingContext(parentalBindingCollector)

/**
 * Creates a new [Layer] from this [LayerContext]
 *
 * @return new [Plot]
 */


// todo


public interface PlotContext : LayerCollectorContext {
    // todo hide
    public val features: MutableMap<FeatureName, PlotFeature>
    public fun toPlot(): Plot {
        return Plot(data, layers, features, bindingCollector.freeScales)
    }
}

@PlotDslMarker
public class NamedDataPlotContext<T: NamedDataInterface>(
    override val data: T,
) : PlotContext, NameDataBindingContext {
    override val bindingCollector: BindingCollector = BindingCollector()
    override val layers: MutableList<Layer> = mutableListOf()
    override val features: MutableMap<FeatureName, PlotFeature> = mutableMapOf()

    override fun groupBy(
        vararg columnPointers: ColumnPointer<*>,
        block: WithGroupingBindingContext.() -> Unit
    ) {
        WithGroupingBindingContext(
            data.groupBy(*columnPointers),
            layers,
            bindingCollector
        ).apply(block)
    }
}


@PlotDslMarker
public class GroupedDataPlotContext(
    override val data: GroupedDataInterface,
    override val layers: MutableList<Layer> = mutableListOf() // TODO
) : PlotContext, WithGroupingBindingContext(data, layers, null) {
    override val bindingCollector: BindingCollector = BindingCollector()
    override val features: MutableMap<FeatureName, PlotFeature> = mutableMapOf()
}

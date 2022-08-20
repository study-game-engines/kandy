package org.jetbrains.kotlinx.ggdsl.letsplot.layers


import org.jetbrains.kotlinx.ggdsl.dsl.*
import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import org.jetbrains.kotlinx.ggdsl.letsplot.*

/* TODO
@PublishedApi

 */
val QQ2 = LetsPlotGeom("qq2")


@PlotDslMarker
// todo move x/y?
class QQ2Context(
    override var data: MutableNamedData,
) : LayerContext() {
    @PublishedApi
    internal val x = XAes(this)
    @PublishedApi
    internal val y = XAes(this)

    val alpha = AlphaAes(this)
    val fillColor = FillAes(this)
    val color = ColorAes(this)
    val size = SizeAes(this)
    val symbol = ShapeAes(this)
    // todo stroke

    object Statistics {
        // TODO
    }

    val Stat = Statistics



    /* TODO
    inline operator fun <reified DomainType : Any> ScalablePositionalAes.invoke(
        stat: BinStat<DomainType>
    ): ScaledUnspecifiedDefaultPositionalMapping<DomainType> {
        val mapping = ScaledUnspecifiedDefaultPositionalMapping(
            this.name,
            stat.toDataSource().scaled(),
            typeOf<DomainType>()
        )
        context.bindingCollector.mappings[this.name] = mapping
        return mapping
    }

    inline operator fun <reified DomainType : Any, RangeType : Any> MappableNonPositionalAes<RangeType>.invoke(
        stat: BinStat<DomainType>
    ): ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType> {
        val mapping = ScaledUnspecifiedDefaultNonPositionalMapping<DomainType, RangeType>(
            this.name,
            stat.toDataSource().scaled(),
            typeOf<DomainType>()
        )
        context.bindingCollector.mappings[this.name] = mapping
        return mapping
    }

     */

}

inline fun <reified T : Any, reified R: Any> PlotContext.qq2(
    sourceX: DataSource<T>,
    sourceY: DataSource<R>,
    block: QQ2Context.() -> Unit
) {
    layers.add(
        QQ2Context(data)
            .apply {
                copyFrom(this@qq2)
                x(sourceX)
                y(sourceY)
            }
            .apply(block)
            .toLayer(QQ2)
    )
}

inline fun <reified T : Any, reified R: Any> PlotContext.qq2(
    sourceX: Iterable<T>,
    sourceY: Iterable<R>,
    block: QQ2Context.() -> Unit
) {
    layers.add(
        QQ2Context(data)
            .apply {
                copyFrom(this@qq2)
                x(sourceX)
                y(sourceY)
            }
            .apply(block)
            .toLayer(QQ2)
    )
}


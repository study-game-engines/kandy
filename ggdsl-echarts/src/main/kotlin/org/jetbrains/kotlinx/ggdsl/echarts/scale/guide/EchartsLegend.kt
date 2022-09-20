package org.jetbrains.kotlinx.ggdsl.echarts.scale.guide


public class Legend<DomainType : Any, RangeType : Any> {
    public var name: String? = null
    public var show: Boolean? = null
    public var calculable: Boolean? = null // todo customize ? move to upper context???
    // todo more
}


public inline operator fun <DomainType : Any, RangeType : Any>
    Legend<DomainType, RangeType>.invoke(block: Legend<DomainType, RangeType>.() -> Unit) {
    apply(block)
}

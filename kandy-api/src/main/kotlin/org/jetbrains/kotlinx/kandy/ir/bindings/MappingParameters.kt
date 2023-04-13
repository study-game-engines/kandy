/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.ir.bindings

import org.jetbrains.kotlinx.kandy.ir.scale.NonPositionalScale
import org.jetbrains.kotlinx.kandy.ir.scale.PositionalScale
import org.jetbrains.kotlinx.kandy.ir.scale.Scale

/**
 *  Parameters of the mapping.
 *
 *  @property scale [Scale] of this mapping.
 */
public interface MappingParameters {
    public val scale: Scale
}

public interface PositionalMappingParameters<DomainType>: MappingParameters {
    public override var scale: PositionalScale<out DomainType>
}

public interface NonPositionalMappingParameters<DomainType, RangeType>: MappingParameters {
    public override var scale: NonPositionalScale<out DomainType, out RangeType>
}
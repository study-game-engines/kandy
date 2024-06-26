/*
* Copyright 2020-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.kandy.echarts.features.text

import org.jetbrains.kotlinx.kandy.echarts.settings.LineType
import org.jetbrains.kotlinx.kandy.util.color.Color
import org.jetbrains.kotlinx.kandy.util.context.SelfInvocationContext

/**
 * Border settings for text style.
 *
 * @property color border [color][Color].
 * @property width border width.
 * @property type border [type][LineType]. By default `solid`.
 *
 * @see Color
 * @see LineType
 */
public class TextBorder(
    public var color: Color? = null,
    public var width: Double? = null,
    public var type: LineType? = null
) :
    SelfInvocationContext {

    internal fun isEmpty(): Boolean =
        color == null && width == null && type == null

    internal fun isNotEmpty(): Boolean = !isEmpty()
}
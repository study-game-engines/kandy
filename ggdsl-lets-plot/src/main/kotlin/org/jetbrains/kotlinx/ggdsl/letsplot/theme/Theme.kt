/*
* Copyright 2020-2022 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
*/

package org.jetbrains.kotlinx.ggdsl.letsplot.theme

public sealed interface Theme {
    public object Grey : Theme
    public object Light : Theme
    public object Classic : Theme
    public object Minimal : Theme
    public object Minimal2 : Theme
    public object None : Theme
}

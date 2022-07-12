package org.jetbrains.kotlinx.ggdsl.dsl

import org.jetbrains.kotlinx.ggdsl.ir.data.DataSource
import org.jetbrains.kotlinx.ggdsl.ir.data.NamedData
import org.jetbrains.kotlinx.ggdsl.ir.data.UnnamedDataSource
import kotlin.reflect.typeOf

/**
 * Returns a new [DataSource].
 *
 * @param T the type of source
 * @param id the name of source in [NamedData]
 */
inline fun <reified T : Any> source(id: String): DataSource<T> =
    DataSource(id, typeOf<T>())


inline fun <reified T : Any> source(): UnnamedDataSource<T> =
    UnnamedDataSource(typeOf<T>())
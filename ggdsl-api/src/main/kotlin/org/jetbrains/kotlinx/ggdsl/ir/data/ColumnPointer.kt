package org.jetbrains.kotlinx.ggdsl.ir.data

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

// todo nullable? ktype
/**
 * Pointer to the data source - a column in the table with the corresponding name.
 *
 * @param T a type of column
 * @property name the name of column in the table
 * @property type reified type of data TODO: was removed
 */
@Serializable(with=CPSerializer::class)
public data class ColumnPointer<T : Any>(val name: String)


public object CPSerializer: KSerializer<ColumnPointer<*>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("ColumnPointer") {
        element<String>("name")
    }

    override fun deserialize(decoder: Decoder): ColumnPointer<*> {
        return ColumnPointer<Any>(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: ColumnPointer<*>) {
        encoder.encodeString(value.name)
    }

}

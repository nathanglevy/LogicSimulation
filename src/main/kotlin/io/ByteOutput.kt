package io

import logicTypes.Bit
import logicTypes.Byte8
import logicTypes.LogicBitEnum

data class ByteOutput(private var connectedTo : LogicInput<Byte8>? = null) :
    LogicOutput<Byte8> {
    override fun getValue(): Byte8 {
        return connectedTo?.getValue() ?: Byte8()
    }
}
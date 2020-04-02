package io

import logicTypes.Bit
import logicTypes.LogicBitEnum

data class BitOutput(private var connectedTo : LogicInput<Bit>? = null) :
    LogicOutput<Bit> {
    override fun getValue(): Bit {
        return connectedTo?.getValue() ?: Bit(LogicBitEnum.HIGH_Z)

    }
}
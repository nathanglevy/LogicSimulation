package io

import logicTypes.Bit
import logicTypes.LogicBitEnum

data class BitInput(private var connectedTo : LogicOutput<Bit>? = null) : LogicInput<Bit> {
    override fun getValue(): Bit {
        return connectedTo?.getValue() ?: Bit(LogicBitEnum.HIGH_Z)
    }

    override fun connect(output: LogicOutput<Bit>) {
        connectedTo = output
    }
}
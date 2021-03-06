package components

import io.LogicOutput
import logicTypes.Bit

class AndGate(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null) : TwoInputLogicGate(aInput,bInput) {
    override fun getValue(): Bit {
        return when {
            a.getValue() == Bit.undefined() || b.getValue() == Bit.undefined() -> Bit.undefined()
            a.getValue() == Bit.high() && b.getValue() == a.getValue() -> Bit.high()
            a.getValue() == Bit.high() && b.getValue() == Bit.highZ() -> Bit.high()
            b.getValue() == Bit.high() && a.getValue() == Bit.highZ() -> Bit.high()
            else -> Bit.low()
        }
    }
}


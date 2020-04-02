package components

import io.LogicOutput
import logicTypes.Bit

class XorGate(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null) : TwoInputLogicGate(aInput,bInput),
    LogicOutput<Bit> {
    override fun getValue(): Bit {
        return when {
            a.getValue() == Bit.undefined() || b.getValue() == Bit.undefined() -> Bit.undefined()
            a.getValue() == Bit.highZ() || b.getValue() == Bit.highZ() -> Bit.undefined()
            a.getValue() == Bit.high() && b.getValue() == Bit.low() -> Bit.high()
            b.getValue() == Bit.high() && a.getValue() == Bit.low() -> Bit.high()
            else -> Bit.low()
        }
    }
}
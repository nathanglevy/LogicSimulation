package components

import io.LogicOutput
import logicTypes.Bit

class NotGate(aInput : LogicOutput<Bit>? = null) : OneInputLogicGate(aInput) {
    override fun getValue(): Bit {
        return when {
            a.getValue() == Bit.undefined() -> Bit.undefined()
            a.getValue() == Bit.high() -> Bit.low()
            a.getValue() == Bit.highZ() -> Bit.undefined()
            else -> Bit.high()
        }
    }
}




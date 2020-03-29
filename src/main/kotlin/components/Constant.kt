package components

import io.LogicOutput
import logicTypes.Bit

class Constant(val constant : Bit) :
    LogicOutput<Bit> {
    override fun getValue(): Bit {
        return constant
    }
}
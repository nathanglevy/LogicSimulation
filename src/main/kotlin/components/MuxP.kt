package components

import io.BitInput
import io.LogicOutput
import logicTypes.Bit

class MuxP(msbInput : LogicOutput<Bit>? = null, lsbInput : LogicOutput<Bit>? = null, s0Input : LogicOutput<Bit>? = null) : LogicOutput<Bit> {
    val msb = BitInput(msbInput)
    val lsb = BitInput(lsbInput)
    val s0 = BitInput(s0Input)

    override fun getValue(): Bit {
        return when {
            s0.getValue() == Bit.high() -> msb.getValue()
            s0.getValue() == Bit.low() -> lsb.getValue()
            else -> Bit.undefined()


        }
    }
}


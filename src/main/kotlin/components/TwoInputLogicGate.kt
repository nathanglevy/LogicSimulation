package components

import io.BitInput
import io.LogicOutput
import logicTypes.Bit

abstract class TwoInputLogicGate(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null) :
    LogicOutput<Bit> {
    val a = BitInput(aInput)
    val b = BitInput(bInput)
}


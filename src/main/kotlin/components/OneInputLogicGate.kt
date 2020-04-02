package components

import io.BitInput
import io.LogicOutput
import logicTypes.Bit

abstract class OneInputLogicGate(aInput : LogicOutput<Bit>? = null) : LogicOutput<Bit> {
    val a = BitInput(aInput)
}
package components

import io.LogicOutput
import logicTypes.Bit

class ThreeXorGate(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null, cInput : LogicOutput<Bit>? = null)
    : ThreeInputLogicGate(aInput,bInput, cInput){
    val xor1  = XorGate(aInput, bInput)
    val result = XorGate(xor1, cInput)
    override fun getValue(): Bit = result.getValue()
}
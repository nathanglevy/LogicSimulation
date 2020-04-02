package components

import io.LogicOutput
import logicTypes.Bit

class ThreeAndGate(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null, cInput : LogicOutput<Bit>? = null)
    : ThreeInputLogicGate(aInput,bInput, cInput){
    val and1  = AndGate(aInput, bInput)
    val and2 = AndGate(and1, cInput)

    override fun getValue(): Bit = and2.getValue()
    }



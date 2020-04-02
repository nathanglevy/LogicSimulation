package components

import io.LogicOutput
import logicTypes.Bit

class muxWithGates (msbInput : LogicOutput<Bit>? = null, lsbInput : LogicOutput<Bit>? = null, s0Input : LogicOutput<Bit>? = null)
    : ThreeInputLogicGate(msbInput ,lsbInput ,s0Input ) {
    /*val msb = BitInput(msbInput)
    val lsb = BitInput(lsbInput)
    val s0 = BitInput(s0Input)*/

    val result = OrGate(AndGate(lsbInput, NotGate(s0Input)), AndGate(msbInput, s0Input)
    )

    override fun getValue(): Bit = result.getValue()

}
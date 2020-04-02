package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.TwoBit

class fullAdder(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null, cinInput : LogicOutput<Bit>? = null)
    : LogicOutput<TwoBit> {
    val sum  = ThreeXorGate(aInput, bInput, cinInput)
    val cout = muxP(OrGate(bInput, cinInput), AndGate(bInput, cinInput), aInput)

    override fun getValue(): Bit = sum.getValue()


}
package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.TwoBit

class FullAdder(aInput : LogicOutput<Bit>? = null, bInput : LogicOutput<Bit>? = null, cinInput : LogicOutput<Bit>? = null)
    : LogicOutput<TwoBit> {
    private val sum  = ThreeXorGate(aInput, bInput, cinInput)
    private val cout = MuxP(OrGate(bInput, cinInput), AndGate(bInput, cinInput), aInput)

    override fun getValue() = TwoBit(sum.getValue(),cout.getValue())
}



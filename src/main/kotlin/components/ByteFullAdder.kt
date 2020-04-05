package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.Byte8
import logicTypes.split

class ByteFullAdder(
    aInput : LogicOutput<Byte8>,
    bInput : LogicOutput<Byte8>,
    cInput : LogicOutput<Bit> = Constant(Bit.low())
)
{
    private val aSplit = aInput.split()
    private val bSplit = bInput.split()
    private val adders = mutableListOf(FullAdder(aSplit[0], bSplit[0], cInput))
    init {
        (1..7).forEach { index ->
            val adder = FullAdder(aSplit[index],bSplit[index],adders[index-1].split()[1])
            adders.add(adder)
        }
    }

    fun getValue(): Byte8 {
        val sValues = adders.map { it.split()[0].getValue() }
        val cout = adders[7].split()[1].getValue()
        return Byte8(sValues)
    }

}



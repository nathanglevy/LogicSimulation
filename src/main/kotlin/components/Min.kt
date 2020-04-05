package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.Byte8
import logicTypes.split

class Min(
    val aInput : LogicOutput<Byte8>,
    bInput : LogicOutput<Byte8>
) : LogicOutput<Byte8>
{
    private val aSplit = aInput.split()
    private val bSplit = bInput.split()
    override fun getValue(): Byte8 {
        var i = 0
        while(aSplit[i].getValue() == bSplit[i].getValue() && i<8)
            i++
        if(i >= 8)
        {
            val defaultVal = aSplit.map { it.getValue() }
            return Byte8(defaultVal)
        }
        if ((aSplit[i].getValue() == Bit.undefined())|| (aSplit[i].getValue() == Bit.highZ()) ||
            (bSplit[i].getValue() == Bit.undefined())|| (bSplit[i].getValue() == Bit.highZ()))
            return Byte8()
        else if (aSplit[i].getValue() == Bit.low()) {
            val aVal = aSplit.map { it.getValue() }
            return Byte8(aVal)
        }
        else {
            val bVal = bSplit.map { it.getValue() }
            return Byte8(bVal)
        }

    }



}
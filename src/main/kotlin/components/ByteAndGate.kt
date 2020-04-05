package components

import io.ByteOutput
import io.LogicOutput
import logicTypes.Bit
import logicTypes.Byte8
import logicTypes.split

class ByteAndGate(private val a: LogicOutput<Byte8>, private val b: LogicOutput<Byte8>) :
    LogicOutput<Byte8> {
    private val aSplit = a.split()
    private val bSplit = b.split()
    private val outputs : List<LogicOutput<Bit>> = (0..7).map { i->
        AndGate(aSplit[i], bSplit[i])
    }

    override fun getValue(): Byte8 {
        val values = outputs.map {
            it.getValue()
        }
        return Byte8(values)
    }
}


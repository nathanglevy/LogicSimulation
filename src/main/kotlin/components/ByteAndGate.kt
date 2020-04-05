package components

import io.LogicOutput
import logicTypes.Byte

class ByteAndGate(val a: LogicOutput<Byte>,val b: LogicOutput<Byte>) :
    LogicOutput<Byte> {


    override fun getValue(): Byte {
        var res : Byte

        for (i in (0..7)) {
            res[i] = AndGate(a[i], b[i])
        }

        return res

    }


}


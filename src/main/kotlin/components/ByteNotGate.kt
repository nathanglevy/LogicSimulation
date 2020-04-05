package components

import io.LogicOutput
import logicTypes.Byte

class ByteNotGate(a: LogicOutput<Byte>, b: LogicOutput<Byte>) :
    LogicOutput<Byte> {


    override fun getValue(): Byte {
        var res : Byte

        for (i in (0..7)) {
            res[i] = NotGateGate(a[i], b[0])
        }

        return res

    }


}
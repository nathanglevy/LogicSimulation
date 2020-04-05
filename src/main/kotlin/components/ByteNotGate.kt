//package components
//
//import io.LogicOutput
//import logicTypes.Byte8
//
//class ByteNotGate(a: LogicOutput<Byte8>, b: LogicOutput<Byte8>) :
//    LogicOutput<Byte8> {
//
//
//    override fun getValue(): Byte8 {
//        var res : Byte8
//
//        for (i in (0..7)) {
//            res[i] = NotGateGate(a[i], b[0])
//        }
//
//        return res
//
//    }
//
//
//}
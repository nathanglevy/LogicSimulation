package logicTypes

import io.LogicOutput

class ConstantDynamic(val bitFunc : ()-> Bit) :
    LogicOutput<Bit> {
    override fun getValue(): Bit {
        return bitFunc()
    }
}
package logicTypes

import io.LogicOutput

data class TwoBit( val first : Bit, val second : Bit) :
    LogicType {
    override val bitSize: Int = 2
}
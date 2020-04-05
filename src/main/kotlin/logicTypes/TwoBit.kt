package logicTypes

import io.LogicOutput

data class TwoBit( val first : Bit, val second : Bit) :
    LogicType {
    override val bitSize: Int = 2
    operator fun get(index : Int) = when(index) {
        0 -> first
        1 -> second
        else -> Bit.undefined()
    }
}

fun LogicOutput<TwoBit>.split() : List<LogicOutput<Bit>> {
    return (0..1).map { index ->
        ConstantDynamic { getValue()[index] }
    }
}


package logicTypes

data class TwoBit( val first : Bit, val second : Bit) :
    LogicType {
    override val bitSize: Int = 2
}
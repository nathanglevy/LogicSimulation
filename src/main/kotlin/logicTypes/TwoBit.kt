package logicTypes

data class TwoBit( val value : Pair<Bit, Bit> ) :
    LogicType {
    override val bitSize: Int = 2

}
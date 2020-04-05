package logicTypes

data class Byte(val value : List<Bit> = (0..7).map { Bit.undefined() }) :
LogicType {
    override val bitSize: Int = 8
}
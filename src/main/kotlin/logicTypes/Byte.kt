package logicTypes

class Byte(val value : List<LogicBitEnum> = (0..7).map { LogicBitEnum.UNDEFINED }) :
    LogicType {
    override val bitSize: Int = 8
}
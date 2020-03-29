package logicTypes

data class Bit(val value : LogicBitEnum = LogicBitEnum.UNDEFINED) : LogicType {
    override val bitSize: Int = 1

    companion object {
        fun high() : Bit = Bit(LogicBitEnum.HIGH)
        fun low() : Bit =  Bit(LogicBitEnum.LOW)
        fun undefined() : Bit = Bit(LogicBitEnum.UNDEFINED)
        fun highZ() : Bit = Bit(LogicBitEnum.HIGH_Z)
    }
}


package logicTypes

import io.LogicOutput
import java.math.BigInteger

data class Bit(val value : LogicBitEnum = LogicBitEnum.UNDEFINED) : LogicType {
    override val bitSize: Int = 1

    companion object {
        fun high() : Bit = Bit(LogicBitEnum.HIGH)
        fun low() : Bit =  Bit(LogicBitEnum.LOW)
        fun undefined() : Bit = Bit(LogicBitEnum.UNDEFINED)
        fun highZ() : Bit = Bit(LogicBitEnum.HIGH_Z)
    }



}



fun Int.intToList() : List<Bit> {
    val bigInt = BigInteger(this.toString(),10)
    return stringToList(bigInt.toString(2).reversed().padEnd(8,'0'))
}



fun stringToList(str: String): List<Bit> {
    val mappedBits = str.map { char ->
        when(char) {
            '1' -> Bit.high()
            '0' -> Bit.low()
            'Z' -> Bit.highZ()
            else -> Bit.undefined()
        }
    }
    return mappedBits
}



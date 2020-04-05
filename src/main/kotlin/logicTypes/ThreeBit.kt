package logicTypes

import java.math.BigInteger

data class ThreeBit(val first : Bit, val second : Bit, val third : Bit) :
    LogicType {
    override val bitSize: Int = 3
    operator fun get(index: Int) = when (index) {
        0 -> first
        1 -> second
        2 -> third
        else -> Bit.undefined()
    }

    companion object {
        fun stringToByte(string: String): ThreeBit {
            val mappedBits = string.map { char ->
                when (char) {
                    '1' -> Bit.high()
                    '0' -> Bit.low()
                    'Z' -> Bit.highZ()
                    else -> Bit.undefined()
                }
            }
            return ThreeBit(mappedBits[0], mappedBits[1], mappedBits[2])
        }

        fun intToThreeBit(int : Int) : ThreeBit {
            val bigInt = BigInteger(int.toString(),10)
            return ThreeBit.stringToByte(bigInt.toString(2).reversed().padEnd(8, '0'))
        }


    }
}
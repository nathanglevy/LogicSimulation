package logicTypes

import io.LogicOutput
import java.math.BigInteger

data class Byte8(private val value : List<Bit> = (0..7).map { Bit.undefined() }) :
LogicType {
    override val bitSize: Int = 8
    operator fun get(index : Int) = value.getOrNull(index) ?: Bit.undefined()
    override fun toString() : String {
        return value.map {
            when(it) {
                Bit.high() -> '1'
                Bit.low() -> '0'
                Bit.undefined() -> 'X'
                Bit.highZ() -> 'Z'
                else -> '?'
            }
        }.joinToString()
    }
    companion object {
        fun stringToByte(string : String) : Byte8 {
            val mappedBits = string.map { char ->
                when(char) {
                    '1' -> Bit.high()
                    '0' -> Bit.low()
                    'Z' -> Bit.highZ()
                    else -> Bit.undefined()
                }
            }
            return Byte8(mappedBits)
        }

        fun intToByte(int : Int) : Byte8 {
            val bigInt = BigInteger(int.toString(),10)
            return stringToByte(bigInt.toString(2).reversed().padEnd(8,'0'))
        }
    }
}

fun LogicOutput<Byte8>.split() : List<LogicOutput<Bit>> {
    return (0..7).map { index ->
        ConstantDynamic { getValue()[index] }
    }
}

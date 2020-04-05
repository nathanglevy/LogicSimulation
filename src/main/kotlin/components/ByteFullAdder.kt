package components

import io.BitInput
import io.BitOutput
import io.LogicOutput
import logicTypes.Bit
import logicTypes.Byte
import logicTypes.LogicBitEnum
import logicTypes.TwoBit

class ByteFullAdder(val aInput : Array<LogicOutput<Bit>> , val bInput : Array<LogicOutput<Bit>>, val cinInput : LogicOutput<Bit>? = null)
{

    fun getValue(): Array<Bit> {
        val constantLow :BitOutput = BitOutput()
        var res: Array<TwoBit>  = arrayOf<TwoBit>()
        var tmpcin: LogicOutput<Bit> = this.cinInput ?: constantLow
        for (n in (0..7)){
            res[n] = FullAdder(aInput[n], bInput[n], tmpcin).getValue()
            tmpcin = (res[n].second)

        }

        // עכשיו נכניס למערך חדש רק את הfirst ואת tmpcin האחרון
        //איך יוצרים את זה בלי בלגןןן
    }

}

// ןרגיסטר- עשה אינטרפייס של קלוק,
// נחזיק Input output  כל עליית שעון out מקבל את in וin מקבל את newin
//
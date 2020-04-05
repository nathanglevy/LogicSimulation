package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.ThreeBit
import logicTypes.split

class CountHigh (val aInput : List<LogicOutput<Bit>>)
    : LogicOutput<ThreeBit> {
    val adder1 = FullAdder(aInput[2], aInput[1], aInput[0])
    val adder2 = FullAdder(aInput[5], aInput[4], aInput[3])
    val adder3 = FullAdder(aInput[6], adder2.split()[0], adder1.split()[0])
    val adder4 = FullAdder(adder2.split()[1], adder1.split()[1], adder3.split()[1])
    override fun getValue(): ThreeBit = ThreeBit(
        adder3.split()[0].getValue(),
        adder4.split()[0].getValue(),
        adder4.split()[1].getValue()
    )


}

fun Int.numOfOne() :Int {
    var num = this
    var counter :Int = 0
    while(num !=0) {
        if (num % 2 == 1)
            counter++
        num /= 2;
    }
    return counter

}
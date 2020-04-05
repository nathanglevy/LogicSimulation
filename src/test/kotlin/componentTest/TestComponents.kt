package componentTest

import components.*
import logicTypes.*
import org.junit.Assert.assertEquals
import org.junit.Test

class TestComponents {
    @Test
    fun simpleTest() {
        val contant1 = Constant(Bit(LogicBitEnum.HIGH))
        assertEquals(Bit(LogicBitEnum.HIGH),contant1.getValue())

        val contant0 = Constant(Bit(LogicBitEnum.LOW))
        assertEquals(Bit(LogicBitEnum.LOW),contant0.getValue())
    }

    @Test
    fun testAndGateHigh() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val andGate = AndGate(constantHigh,constantHigh)
        andGate.a.connect(constantHigh)
        andGate.b.connect(constantHigh)
        assertEquals(Bit.high(),andGate.getValue())
    }

    @Test
    fun testAndGateLow() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val andGate = AndGate(constantHigh,constantLow)
        assertEquals(Bit.low(),andGate.getValue())
    }

    @Test
    fun testAndGateUndefined() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.UNDEFINED))
        val andGate = AndGate(constantHigh,constantLow)
        assertEquals(Bit(LogicBitEnum.UNDEFINED),andGate.getValue())
    }

@Test
fun testAndGateHighZ() {
    val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
    val constantLow = Constant(Bit(LogicBitEnum.HIGH_Z))
    val andGate = AndGate(constantHigh,constantLow)
    assertEquals(Bit.high(),andGate.getValue())
}

@Test
fun testOrGateHigh() {
    val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
    val constantLow = Constant(Bit(LogicBitEnum.LOW))
    val orGate = OrGate(constantHigh,constantLow)
    assertEquals(Bit.high(),orGate.getValue())
}
    @Test
    fun testXorGateLow() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val xorGate = XorGate(constantHigh,constantHigh)
        xorGate.a.connect(constantHigh)
        xorGate.b.connect(constantHigh)
        assertEquals(Bit.low(),xorGate.getValue())
    }

    @Test
    fun testXorGateHigh() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val xorGate = XorGate(constantHigh,constantLow)
        assertEquals(Bit.high(),xorGate.getValue())
    }

    @Test
    fun testXorGateUndefined() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.UNDEFINED))
        val xorGate = XorGate(constantHigh,constantLow)
        assertEquals(Bit(LogicBitEnum.UNDEFINED),xorGate.getValue())
    }

    @Test
    fun testXorGateHighZ() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.HIGH_Z))
        val xorGate = XorGate(constantHigh,constantLow)
        assertEquals(Bit(LogicBitEnum.UNDEFINED),xorGate.getValue())
    }

    @Test
    fun testNotGateHigh() {
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val notGate = NotGate(constantLow)
        assertEquals(Bit(LogicBitEnum.HIGH),notGate.getValue())
    }

    @Test
    fun testNotGateLow() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val notGate = NotGate(constantHigh)
        assertEquals(Bit(LogicBitEnum.LOW),notGate.getValue())
    }

    @Test
    fun testNotGateHighZ() {
        val constantHighZ = Constant(Bit(LogicBitEnum.HIGH_Z))
        val notGate = NotGate(constantHighZ)
        assertEquals(Bit(LogicBitEnum.UNDEFINED),notGate.getValue())
    }

    @Test
    fun testNotGateUnDefined() {
        val constantUnDefined = Constant(Bit(LogicBitEnum.UNDEFINED))
        val notGate = NotGate(constantUnDefined)
        assertEquals(Bit(LogicBitEnum.UNDEFINED),notGate.getValue())
    }

    @Test
    fun testmuxPLow() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val mux = MuxP(constantHigh,constantLow,constantLow)
        assertEquals(Bit(LogicBitEnum.LOW),mux.getValue())
    }
    @Test
    fun testmuxPHigh() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val mux = MuxP(constantHigh,constantLow,constantHigh)
        assertEquals(Bit(LogicBitEnum.HIGH),mux.getValue())
    }

    @Test
    fun muxWithGatesLow() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val mux = MuxWithGates(constantHigh,constantLow,constantHigh)
        assertEquals(Bit(LogicBitEnum.HIGH),mux.getValue())
    }

    @Test
    fun adder1() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val adder = FullAdder(constantLow,constantLow,constantLow)
        assertEquals(TwoBit(Bit.low(),Bit.low()),adder.getValue())
    }

    @Test
    fun adder2() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val adder = FullAdder(constantHigh,constantLow,constantLow)

        assertEquals(TwoBit(Bit.high(),Bit.low()),adder.getValue())
    }

    @Test
    fun adder3() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val adder = FullAdder(constantHigh,constantLow,constantHigh)

        assertEquals(TwoBit(Bit.low(),Bit.high()),adder.getValue())
    }

    @Test
    fun adder4() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val adder = FullAdder(constantHigh,constantHigh,constantHigh)
        assertEquals(TwoBit(Bit.high(),Bit.high()),adder.getValue())
    }

    @Test
    fun adder5() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantundefined = Constant(Bit(LogicBitEnum.UNDEFINED))
        val adder = FullAdder(constantundefined,constantHigh,constantHigh)
        assertEquals(TwoBit(Bit.undefined(),Bit.undefined()),adder.getValue())
    }

    @Test
    fun adder6() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantundefined = Constant(Bit(LogicBitEnum.UNDEFINED))
        val adder = FullAdder(constantHigh,constantundefined,constantHigh)
        assertEquals(TwoBit(Bit.undefined(),Bit.undefined()),adder.getValue())
    }

    @Test
    fun adder7() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantundefined = Constant(Bit(LogicBitEnum.UNDEFINED))
        val adder = FullAdder(constantHigh,constantHigh,constantundefined)
        assertEquals(TwoBit(Bit.undefined(),Bit.undefined()),adder.getValue())
    }


    @Test
    fun xor3gate() {
        val constantHigh = Constant(Bit(LogicBitEnum.HIGH))
        val constantLow = Constant(Bit(LogicBitEnum.LOW))
        val xor = ThreeXorGate(constantHigh,constantHigh,constantHigh)
        assertEquals(Bit(LogicBitEnum.HIGH),xor.getValue())

    }

    @Test
    fun simpleAdderTest() {
        val a = Constant(Byte8.stringToByte("10101010"))
        val b = Constant(Byte8.stringToByte("01010101"))
        val byteAdder = ByteFullAdder(a,b)
        val output = byteAdder.getValue()
        assertEquals(Byte8.stringToByte("11111111"), output)
    }

    @Test
    fun dynamicAdderTest() {
        (0..8).forEach { a ->
            (0..8).forEach { b ->
                val aInput = Constant(Byte8.intToByte(a))
                val bInput = Constant(Byte8.intToByte(b))
                val byteAdder = ByteFullAdder(aInput,bInput)
                val output = byteAdder.getValue()
                println("Expected: $a + $b = ${a+b}")
                println("Got: $a + $b = $output")
                assertEquals(Byte8.intToByte((a + b) % 256), output)
            }
        }


    }

    @Test
    fun dynamicCountHighTest() {
        (0..127).forEach { a ->
                val aInput =(a.intToList())
                val aaa= aInput.map{index -> Constant(index)}
                val countHigh = CountHigh(aaa)
                val output = countHigh.getValue()
            println("Expected: ${a.numOfOne()} (the num is $a)")
            println("Got:  $output")
                assertEquals( ThreeBit.intToThreeBit(a.numOfOne()) , output)
            }
        }


    }






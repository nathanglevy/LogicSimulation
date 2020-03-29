package componentTest

import components.AndGate
import components.Constant
import components.OrGate
import logicTypes.Bit
import logicTypes.LogicBitEnum
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
}
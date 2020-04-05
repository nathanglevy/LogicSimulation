package components

import io.LogicOutput
import logicTypes.Bit
import logicTypes.LogicType

class Constant<T : LogicType> (val constant : T) :
    LogicOutput<T> {
    override fun getValue(): T {
        return constant
    }
}
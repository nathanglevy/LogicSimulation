package io

import logicTypes.Bit
import logicTypes.LogicType

interface LogicOutput<T : LogicType> {
    fun getValue() : T
}
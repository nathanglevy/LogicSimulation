package io

import logicTypes.LogicType

interface LogicInput<T : LogicType> {
    fun getValue() : T
    fun connect(output : LogicOutput<T>)
}


package io

import logicTypes.LogicType

interface LogicOutput<T : LogicType> {
    fun getValue() : T
}
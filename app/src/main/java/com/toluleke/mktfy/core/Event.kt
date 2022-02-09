package com.toluleke.mktfy.core

class Event(value: Boolean = true){
    private var _value = value
    fun value(): Boolean{
        val value = _value
        _value = false
        return value
    }
}
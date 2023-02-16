package com.example.coroutines

interface DataCallback<T> {

    fun returnValue(value: T)
}
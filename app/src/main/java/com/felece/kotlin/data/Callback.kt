package com.felece.kotlin.data

interface Callback<T> {

    fun onSuccess(response:T?)
    fun onError(errorCode:Int,errorMessage:String)
}
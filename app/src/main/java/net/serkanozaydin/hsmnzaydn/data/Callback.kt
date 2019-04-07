package net.serkanozaydin.hsmnzaydn.data

interface Callback<T> {

    fun onSuccess(response:T?)
    fun onError(errorCode:Int,errorMessage:String)
}
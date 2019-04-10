package net.serkanozaydin.hsmnzaydn.data

interface ServiceCallback<T> {

    fun onSuccess(response:T?)
    fun onError(errorCode:Int,errorMessage:String)
}
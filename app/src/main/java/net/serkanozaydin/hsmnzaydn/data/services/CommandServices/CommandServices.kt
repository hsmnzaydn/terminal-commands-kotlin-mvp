package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import android.telecom.Call
import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.entity.Command

interface CommandServices{

    fun getCommandQuery(language:String,query:String,callback: Callback<List<Command>>)
}
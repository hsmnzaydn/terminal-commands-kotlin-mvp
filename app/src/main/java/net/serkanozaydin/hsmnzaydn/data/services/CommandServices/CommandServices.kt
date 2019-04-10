package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Command

interface CommandServices{

    fun getCommandQuery(query:String, serviceCallback: ServiceCallback<List<Command>>)
}
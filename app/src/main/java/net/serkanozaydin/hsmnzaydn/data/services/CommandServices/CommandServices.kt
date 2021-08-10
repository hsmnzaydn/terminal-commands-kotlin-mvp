package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback

interface CommandServices{

    fun getCommandQuery(query:String, serviceCallback: ServiceCallback<List<Command>>)
}
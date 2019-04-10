package net.serkanozaydin.hsmnzaydn.data.db.Command

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Command

interface CommandDb {
    fun addCommand(command:Command)
    fun deleteCommand(command: Command)
    fun getAllCommands(callback: ServiceCallback<List<Command>>)
}
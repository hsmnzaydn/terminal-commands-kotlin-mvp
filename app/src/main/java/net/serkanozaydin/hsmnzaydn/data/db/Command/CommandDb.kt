package net.serkanozaydin.hsmnzaydn.data.db.Command

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback

interface CommandDb {
    fun addCommand(command: Command)
    fun deleteCommand(command: Command)
    fun getAllCommands(callback: ServiceCallback<List<Command>>)
    fun updateCommand(command: Command)
}
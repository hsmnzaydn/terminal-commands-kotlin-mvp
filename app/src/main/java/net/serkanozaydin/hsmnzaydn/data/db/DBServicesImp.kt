package net.serkanozaydin.hsmnzaydn.data.db

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.db.Command.CommandDb
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import javax.inject.Inject

class DBServicesImp:DBServices {

    lateinit var commandDb:CommandDb

    @Inject
    constructor(commandDb: CommandDb){
        this.commandDb=commandDb
    }



    override fun addCommand(command: Command) {
        commandDb.addCommand(command)
    }

    override fun deleteCommand(command: Command) {
        commandDb.deleteCommand(command)
    }

    override fun getAllCommands(callback: ServiceCallback<List<Command>>) {
        commandDb.getAllCommands(callback)
    }

    override fun updateCommand(command: Command) {
        commandDb.updateCommand(command)
    }

}
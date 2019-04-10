package net.serkanozaydin.hsmnzaydn.data.db.Command

import android.content.Context
import androidx.room.Room
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.db.AppDatabase
import net.serkanozaydin.hsmnzaydn.data.db.CommandDao
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import javax.inject.Inject

class CommandDbImp:CommandDb{

    lateinit var db:AppDatabase

    @Inject
    constructor(context: Context){
        this.db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "command"
        ).build()
    }


    override fun addCommand(command: Command) {
        db.userDao().insertAll(command)
    }

    override fun deleteCommand(command: Command) {
        db.userDao().delete(command)
    }

    override fun getAllCommands(callback: ServiceCallback<List<Command>>) {
        callback.onSuccess(db.userDao().getAllCommand())
    }


}
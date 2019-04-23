package net.serkanozaydin.hsmnzaydn.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import net.serkanozaydin.hsmnzaydn.data.entity.Command


@Dao
interface CommandDao {
    @Query("SELECT * FROM command")
    fun getAllCommand():List<Command>

    @Query("SELECT * FROM command WHERE title LIKE :title AND " +
            "description LIKE :description LIMIT 1")
    fun findByName(title: String, description: String): Command


    @Query("UPDATE command SET title=:title, description=:description WHERE uid= :uid")
    fun updateCommand(title:String,description: String,uid:Int)


    @Insert
    fun insertAll(vararg command: Command):List<Long>

    @Delete
    fun delete(command: Command)
}
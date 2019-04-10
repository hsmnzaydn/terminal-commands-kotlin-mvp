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

    @Insert
    fun insertAll(vararg command: Command)

    @Delete
    fun delete(command: Command)
}
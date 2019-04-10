package net.serkanozaydin.hsmnzaydn.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import net.serkanozaydin.hsmnzaydn.data.entity.Command


@Database(entities = arrayOf(Command::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): CommandDao
}
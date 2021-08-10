package net.serkanozaydin.hsmnzaydn.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Command(

    @SerializedName("id")
    @ColumnInfo(name = "Command Id")
    var id: String,
    @SerializedName("description")
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    var title: String
){
    @PrimaryKey(autoGenerate = true)
    var uid:Int = 0
}
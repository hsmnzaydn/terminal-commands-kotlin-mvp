package net.serkanozaydin.hsmnzaydn.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Command(
    @PrimaryKey var uid:Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
)
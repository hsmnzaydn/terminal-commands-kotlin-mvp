package net.serkanozaydin.hsmnzaydn.data.entity

import com.google.gson.annotations.SerializedName

data class Command(

    @SerializedName("_id")
    val id: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)
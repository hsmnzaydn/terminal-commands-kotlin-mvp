package net.serkanozaydin.hsmnzaydn.data.entity

import com.google.gson.annotations.SerializedName

data class Command(
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("detail")
    val detail: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("text")
    val text: String
)
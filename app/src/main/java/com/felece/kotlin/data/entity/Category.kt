package com.felece.kotlin.data.entity
import com.google.gson.annotations.SerializedName


data class Category(
    @SerializedName("__v")
    val v: Int,
    @SerializedName("_id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("title")
    val title: String
)
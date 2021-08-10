package net.serkanozaydin.hsmnzaydn.data.entity

import com.google.gson.annotations.SerializedName

data class Language(
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("languageShooter")
    val languageShooter: String
)
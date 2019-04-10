package net.serkanozaydin.hsmnzaydn.data.services

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import retrofit2.Call
import retrofit2.http.*

interface Services {

    @GET("categories")
    fun getCategories(): Call<List<Category>>


    @GET("categories/{categoryId}/commands")
    fun getCommandOfCategory(@Path("categoryId") categoryId:String):Call<List<Command>>

    @GET("commands")
    fun getCommands(@Query("commandTitle") query: String):Call<List<Command>>

    @GET("languages")
    fun getLanguages():Call<List<Language>>
}
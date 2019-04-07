package net.serkanozaydin.hsmnzaydn.data.services

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import retrofit2.Call
import retrofit2.http.*

interface Services {

    @Headers("Cache-Control: public, max-stale=604800")
    @GET("categories")
    fun getCategories(@Query("language") language:String): Call<List<Category>>


    @GET("categories/{categoryId}/commands")
    fun getCommandOfCategory(@Path("categoryId") categoryId:String):Call<List<Command>>

    @GET("commands")
    fun getCommands(@Query("language") language: String,@Query("commandTitle") query: String):Call<List<Command>>
}
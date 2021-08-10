package net.serkanozaydin.hsmnzaydn.data.services

import net.serkanozaydin.hsmnzaydn.data.entity.*
import retrofit2.Call
import retrofit2.http.*

interface Services {
    @POST("accounts")
    fun registerUser(@Body userRegisterRequest: UserRegisterRequest):Call<CoreBaseResponse<UserRegisterResponse>>


    @GET("categories")
    fun getCategories(): Call<CoreBaseResponse<List<Category>>>


    @GET("categories/{categoryId}/commands")
    fun getCommandOfCategory(@Path("categoryId") categoryId:String):Call<CoreBaseResponse<List<Command>>>

    @GET("commands")
    fun getCommands(@Query("commandTitle") query: String):Call<CoreBaseResponse<List<Command>>>

    @GET("languages")
    fun getLanguages():Call<CoreBaseResponse<List<Language>>>
}
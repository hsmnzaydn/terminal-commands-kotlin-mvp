package net.serkanozaydin.hsmnzaydn.data

import net.serkanozaydin.hsmnzaydn.data.entity.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {


    @GET("categories")
    fun getCategories(@Query("language") language:String): Call<List<Category>>
}
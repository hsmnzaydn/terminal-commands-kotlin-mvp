package com.felece.kotlin.data

import com.felece.kotlin.data.entity.Category
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Services {


    @GET("categories")
    fun getCategories(@Query("language") language:String): Call<List<Category>>
}
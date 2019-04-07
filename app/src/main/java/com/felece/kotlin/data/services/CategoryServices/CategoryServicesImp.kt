package com.felece.kotlin.data.services.CategoryServices

import com.felece.kotlin.RetrofitClient
import com.felece.kotlin.data.ApiServices
import com.felece.kotlin.data.ApiServicesImp
import com.felece.kotlin.data.Callback
import com.felece.kotlin.data.Services
import com.felece.kotlin.data.entity.Category
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CategoryServicesImp : CategoryServices {

    lateinit var apiServices:Services


    @Inject
    constructor(retrofitClient: RetrofitClient){
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun getCategories(language: String, callback: Callback<List<Category>>) {
        var call = apiServices.getCategories(language)

        call.enqueue(object : retrofit2.Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                    callback.onError(500,t.message.toString())
            }

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                callback.onSuccess(response.body())
            }

        })
    }

}
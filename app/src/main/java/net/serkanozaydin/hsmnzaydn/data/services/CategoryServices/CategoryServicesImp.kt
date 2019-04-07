package net.serkanozaydin.hsmnzaydn.data.services.CategoryServices


import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import net.serkanozaydin.hsmnzaydn.data.entity.Category
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CategoryServicesImp : CategoryServices {


    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient) {
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun getCategories(language: String, callback: Callback<List<Category>>) {
        var call = apiServices.getCategories(language)

        call.enqueue(object : retrofit2.Callback<List<Category>> {
            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                callback.onError(500, t.message.toString())
            }

            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                callback.onSuccess(response.body())
            }

        })
    }

    override fun getCommandsOfCategory(categoryId: String, callback: Callback<List<Command>>) {
        var call = apiServices.getCommandOfCategory(categoryId)

        call.enqueue(object : retrofit2.Callback<List<Command>> {
            override fun onFailure(call: Call<List<Command>>, t: Throwable) {
                callback.onError(500, t.message.toString())
            }

            override fun onResponse(call: Call<List<Command>>, response: Response<List<Command>>) {
                callback.onSuccess(response.body())
            }

        })


    }

}
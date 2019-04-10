package net.serkanozaydin.hsmnzaydn.data.services.LanguageServices

import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LanguageServicesImp:LanguageServices {
    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient){
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun getLanguages(callback: ServiceCallback<List<Language>>) {
        var call=apiServices.getLanguages()

        call.enqueue(object : Callback<List<Language>>{
            override fun onFailure(call: Call<List<Language>>, t: Throwable) {
                callback.onError(500,t.message.toString())
            }

            override fun onResponse(call: Call<List<Language>>, response: Response<List<Language>>) {
                callback.onSuccess(response.body())
            }

        })
    }
}
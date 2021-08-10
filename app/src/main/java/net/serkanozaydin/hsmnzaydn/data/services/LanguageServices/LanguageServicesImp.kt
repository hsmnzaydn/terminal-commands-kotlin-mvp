package net.serkanozaydin.hsmnzaydn.data.services.LanguageServices

import net.serkanozaydin.hsmnzaydn.data.entity.Language
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.services.CoreBaseResponse
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import retrofit2.Call
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

        call.enqueue(object : retrofit2.Callback<CoreBaseResponse<List<Language>>> {

            override fun onFailure(p0: Call<CoreBaseResponse<List<Language>>>, p1: Throwable) {
                callback.onError(500,p1.localizedMessage)
            }

            override fun onResponse(
                p0: Call<CoreBaseResponse<List<Language>>>,
                p1: Response<CoreBaseResponse<List<Language>>>
            ) {
                callback.onSuccess(p1.body()?.data)
            }

        })

    }
}
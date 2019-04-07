package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import net.serkanozaydin.hsmnzaydn.data.Callback
import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.services.RetrofitClient
import net.serkanozaydin.hsmnzaydn.data.services.Services
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class CommandServicesImp:CommandServices {


    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient){
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }


    override fun getCommandQuery(language:String,query: String, callback: Callback<List<Command>>) {
        var call=apiServices.getCommands(language,query)
        call.enqueue(object : retrofit2.Callback<List<Command>>{
            override fun onFailure(call: Call<List<Command>>, t: Throwable) {

                callback.onError(500,t.message.toString())
            }

            override fun onResponse(call: Call<List<Command>>, response: Response<List<Command>>) {
                callback.onSuccess(response.body())
            }

        })


    }

}
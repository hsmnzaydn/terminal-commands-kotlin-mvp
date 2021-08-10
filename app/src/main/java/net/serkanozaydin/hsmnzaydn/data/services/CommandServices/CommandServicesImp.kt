package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import net.serkanozaydin.hsmnzaydn.data.entity.Command
import net.serkanozaydin.hsmnzaydn.data.ServiceCallback
import net.serkanozaydin.hsmnzaydn.data.services.CoreBaseResponse
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


    override fun getCommandQuery(query: String, serviceCallback: ServiceCallback<List<Command>>) {
        var call=apiServices.getCommands(query)
        call.enqueue(object : retrofit2.Callback<CoreBaseResponse<List<Command>>> {

            override fun onFailure(p0: Call<CoreBaseResponse<List<Command>>>, p1: Throwable) {
                serviceCallback.onError(500,p1.localizedMessage)
            }

            override fun onResponse(
                p0: Call<CoreBaseResponse<List<Command>>>,
                p1: Response<CoreBaseResponse<List<Command>>>
            ) {
                serviceCallback.onSuccess(p1.body()?.data)
            }

        })



    }

}
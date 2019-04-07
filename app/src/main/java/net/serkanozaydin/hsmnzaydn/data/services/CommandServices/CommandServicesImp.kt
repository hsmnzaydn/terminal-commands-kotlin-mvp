package net.serkanozaydin.hsmnzaydn.data.services.CommandServices

import net.serkanozaydin.hsmnzaydn.data.Services
import javax.inject.Inject

class CommandServicesImp:CommandServices {

    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: net.serkanozaydin.hsmnzaydn.RetrofitClient){
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }

}
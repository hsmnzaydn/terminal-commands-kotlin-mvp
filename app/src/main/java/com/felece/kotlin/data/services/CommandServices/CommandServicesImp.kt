package com.felece.kotlin.data.services.CommandServices

import com.felece.kotlin.RetrofitClient
import com.felece.kotlin.data.Services
import javax.inject.Inject

class CommandServicesImp:CommandServices {

    lateinit var apiServices: Services


    @Inject
    constructor(retrofitClient: RetrofitClient){
        apiServices = retrofitClient.getClient().create(Services::class.java)

    }

}
package net.serkanozaydin.hsmnzaydn.data

import android.content.Context
import net.serkanozaydin.hsmnzaydn.Utility.BASE_SERVER_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    constructor(context: Context) {

    }

    fun getClient(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_SERVER_URL).addConverterFactory(GsonConverterFactory.create()).build()


    }
}
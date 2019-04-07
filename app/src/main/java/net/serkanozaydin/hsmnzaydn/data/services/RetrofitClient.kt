package net.serkanozaydin.hsmnzaydn.data.services

import android.content.Context
import net.serkanozaydin.hsmnzaydn.Utility.BASE_SERVER_URL
import net.serkanozaydin.hsmnzaydn.Utility.connectTimeOut
import net.serkanozaydin.hsmnzaydn.Utility.readTimeOut
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    lateinit var context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun getClient(): Retrofit {

        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(context.cacheDir, cacheSize.toLong())


        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            .cache(cache)
            .build()


        return Retrofit.Builder().baseUrl(BASE_SERVER_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()

    }
}
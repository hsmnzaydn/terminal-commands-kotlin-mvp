package net.serkanozaydin.hsmnzaydn.data.services

import android.content.Context
import net.serkanozaydin.hsmnzaydn.Utility.BASE_SERVER_URL
import net.serkanozaydin.hsmnzaydn.Utility.connectTimeOut
import net.serkanozaydin.hsmnzaydn.Utility.readTimeOut
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient {
    lateinit var context: Context
    lateinit var prefHelper: PrefHelper

    @Inject
    constructor(context: Context, prefHelper: PrefHelper) {
        this.context = context
        this.prefHelper = prefHelper
    }

    fun getClient(): Retrofit {

        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(context.cacheDir, cacheSize.toLong())


        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    var request: Request =
                        chain.request().newBuilder().addHeader("app-language", prefHelper.getLanguage()).build()
                    return chain.proceed(request)
                }

            })
            .build()


        return Retrofit.Builder().baseUrl(BASE_SERVER_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }
}
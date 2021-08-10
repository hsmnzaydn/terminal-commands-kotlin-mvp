package net.serkanozaydin.hsmnzaydn.data.services

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import net.serkanozaydin.hsmnzaydn.Utility.BASE_SERVER_URL
import net.serkanozaydin.hsmnzaydn.Utility.connectTimeOut
import net.serkanozaydin.hsmnzaydn.Utility.readTimeOut
import net.serkanozaydin.hsmnzaydn.data.pref.PrefHelper
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File


class RetrofitClient {
    lateinit var context: Context
    lateinit var prefHelper: PrefHelper

    @Inject
    constructor(context: Context, prefHelper: PrefHelper) {
        this.context = context
        this.prefHelper = prefHelper
    }

    fun getClient(): Retrofit {
        val file = File(context.cacheDir,"responses")
        val cacheSize = 10 * 1024 * 1024
        val cache = Cache(file, cacheSize.toLong())

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(readTimeOut, TimeUnit.SECONDS)
            .connectTimeout(connectTimeOut, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {

                    var request: Request =
                        chain.request().newBuilder().addHeader("app-language", prefHelper.getLanguage())
                            .addHeader("Authorization","Bearer ${prefHelper.getAuthorizationKey()}").build()
                    if (!hasNetwork(context)!!) {
                        val maxStale = 60 * 60 * 24 * 28
                        return chain.proceed(chain.request().newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                            .build())

                    }
                    return chain.proceed(request)
                }

            })
            .addInterceptor(loggingInterceptor)

            .build()


        return Retrofit.Builder().baseUrl(BASE_SERVER_URL).client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create()).build()

    }



    fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }
}
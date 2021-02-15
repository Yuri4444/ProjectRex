package com.berezhnoyyuri9999.projectrex.data.api

import android.content.Context
import android.util.Log
import com.berezhnoyyuri9999.projectrex.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitManager(private val context: Context) : NetManager {

    private var api: API

    override fun getApi() = api

    init {
        val httpLoggingInterceptor by lazy {
            val logger = HttpLoggingInterceptor {
                Log.d("OkHttp", it)
            }
            logger.level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            logger
        }

        val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(httpLoggingInterceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API.BASE_URL)
            .build()

        api = retrofit.create(API::class.java)
    }


}
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








//    private var bill : Bill? = null
//    private var sumBill = bill?.billAmount
//
////        val a = unpaidBills[11]
//        var sum = 0.0
//        for(i in unpaidBills) {
//             sum += i.billAmount!!
//
//        }
//
//        var sum2 = 0.0
//        for(i in 0..unpaidBills.size) {
//            sum2 += unpaidBills[i].billAmount!!
//
//        }
//
//        var sum3 = 0.0
//        unpaidBills.forEach {
//            sum3 += it.billAmount!!
//        }
//
//        var sum4 = unpaidBills.sumByDouble {
//            it.billAmount ?: 0.0
//        }
//
//        tvToPay.text = sum4.toString()
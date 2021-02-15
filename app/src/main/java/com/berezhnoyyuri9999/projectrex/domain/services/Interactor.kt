package com.berezhnoyyuri9999.projectrex.domain.services

import android.content.Context
import android.net.ConnectivityManager
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class Interactor(private val app: App) {

    private val net by lazy { app.getNetRepository() }

    fun getFlyEn() : Single<List<ProductFly>> {
        return net.getProductFlyEn()
            .subscribeOn(Schedulers.io())
    }

    fun getFlyRu() : Single<List<ProductFly>> {
        return net.getProductFlyRu()
            .subscribeOn(Schedulers.io())
    }

    fun getLandEn() : Single<List<ProductLand>> {
        return net.getProductLandEn()
            .subscribeOn(Schedulers.io())
    }

    fun getLandRu() : Single<List<ProductLand>> {
        return net.getProductLandRu()
            .subscribeOn(Schedulers.io())
    }

    fun getSwimEn() : Single<List<ProductSwim>> {
        return net.getProductSwimEn()
            .subscribeOn(Schedulers.io())
    }

    fun getSwimRu() : Single<List<ProductSwim>> {
        return net.getProductSwimRu()
            .subscribeOn(Schedulers.io())
    }

//    fun getSkeleton() : Single<List<ProductSkeleton>> {
//        return net.getProductSkeleton(productSkeleton)
//            .subscribeOn(Schedulers.io())
//    }

    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

}
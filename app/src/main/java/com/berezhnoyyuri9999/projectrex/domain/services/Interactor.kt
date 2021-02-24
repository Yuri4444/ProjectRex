package com.berezhnoyyuri9999.projectrex.domain.services

import android.content.Context
import android.net.ConnectivityManager
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityRu
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class Interactor(private val app: App) {

    private val net by lazy { app.getNetRepository() }

    fun getFlyEn(): Single<List<ProductFly>> {
        return net.getProductFlyEn()
            .subscribeOn(Schedulers.io())
    }

    fun getFlyRu(): Single<List<ProductFly>> {
        return net.getProductFlyRu()
            .subscribeOn(Schedulers.io())
    }

    fun getLandEn(): Single<List<ProductLand>> {
        return net.getProductLandEn()
            .subscribeOn(Schedulers.io())
    }

    fun getLandRu(): Single<List<ProductLand>> {
        return net.getProductLandRu()
            .subscribeOn(Schedulers.io())
    }

    fun getSwimEn(): Single<List<ProductSwim>> {
        return net.getProductSwimEn()
            .subscribeOn(Schedulers.io())
    }

    fun getSwimRu(): Single<List<ProductSwim>> {
        return net.getProductSwimRu()
            .subscribeOn(Schedulers.io())
    }


//    ____________________________________________Room


    private val room by lazy { app.getRoomRepository() }

    fun insertFlyEn(note : FlyEntityEn): Single<Boolean> {
        return room.insertFlyEn(note)
            .subscribeOn(Schedulers.io())
    }

    fun insertFlyRu(note : FlyEntityRu): Single<Boolean> {
        return room.insertFlyRu(note)
            .subscribeOn(Schedulers.io())
    }

    fun insertLandEn(note: LandEntityEn) : Single<Boolean> {
        return room.insertLandEn(note)
            .subscribeOn(Schedulers.io())
    }

    fun insertLandRu(note: LandEntityRu) : Single<Boolean> {
        return room.insertLandRu(note)
            .subscribeOn(Schedulers.io())
    }

    fun insertSwimEn(note : SwimEntityEn) : Single<Boolean> {
        return room.insertSwimEn(note)
            .subscribeOn(Schedulers.io())
    }

    fun insertSwimEn(note : SwimEntityRu) : Single<Boolean> {
        return room.insertSwimRu(note)
            .subscribeOn(Schedulers.io())
    }

    fun selectAllFlyEn() : Single<List<FlyEntityEn>> {
        return room.selectAllFlyEn()
            .subscribeOn(Schedulers.io())
    }

    fun selectAllFlyRu() : Single<List<FlyEntityRu>> {
        return room.selectAllFlyRu()
            .subscribeOn(Schedulers.io())
    }

    fun selectAllLandEn() : Single<List<LandEntityEn>> {
        return room.selectAllLandEn()
            .subscribeOn(Schedulers.io())
    }

    fun selectAllLandRu() : Single<List<LandEntityRu>> {
        return room.selectAllLandRu()
            .subscribeOn(Schedulers.io())
    }

    fun selectSwimEn() : Single<List<SwimEntityEn>> {
        return room.selectAllSwimEn()
            .subscribeOn(Schedulers.io())
    }

    fun selectSwimRu() : Single<List<SwimEntityRu>> {
        return room.selectAllSwimRu()
            .subscribeOn(Schedulers.io())
    }



}
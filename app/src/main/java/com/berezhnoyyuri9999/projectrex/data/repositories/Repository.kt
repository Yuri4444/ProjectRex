package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {
    //Y
    fun getFlyEnDinos(): Observable<List<GlobalEntity>>
    fun getLandEnDinos(): Observable<List<GlobalEntity>>
    fun getLandRuDinos(): Observable<List<GlobalEntity>>
    fun getSwimEnDinos(): Observable<List<GlobalEntity>>
    fun getSwimRuDinos(): Observable<List<GlobalEntity>>


    fun getFlyRuDinos(): Observable<List<GlobalEntity>>

    interface NetRepository {
        fun getProductFlyEn(): Observable<List<ProductFly>>
        fun getProductFlyRu(): Observable<List<ProductFly>>

        fun getProductLandEn(): Observable<List<ProductLand>>
        fun getProductLandRu(): Observable<List<ProductLand>>

//    fun getProductSkeleton(productSkeleton : ProductSkeleton): Single<List<ProductSkeleton>>

        fun getProductSwimEn(): Observable<List<ProductSwim>>
        fun getProductSwimRu(): Observable<List<ProductSwim>>
    }

    interface RoomRepository {
        fun insertFlyEn(entity: GlobalEntity): Observable<Boolean>
        fun insertFlyRu(entity: GlobalEntity): Observable<Boolean>

        fun insertLandEn(entity: GlobalEntity): Observable<Boolean>
        fun insertLandRu(entity : GlobalEntity) : Observable<Boolean>
        fun insertSwimEn(entity : GlobalEntity) : Observable<Boolean>
        fun insertSwimRu(entity : GlobalEntity) : Observable<Boolean>
//
        fun selectAllFlyEn(): Observable<List<GlobalEntity>>
        fun selectAllFlyRu(): Observable<List<GlobalEntity>>
        fun selectAllLandEn() : Observable<List<GlobalEntity>>
        fun selectAllLandRu() : Observable<List<GlobalEntity>>
        fun selectAllSwimEn() : Observable<List<GlobalEntity>>
        fun selectAllSwimRu() : Observable<List<GlobalEntity>>
    }

}
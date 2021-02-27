package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

    fun getFlyDinos(): Observable<List<FlyEntityRu>>

    interface NetRepository {
        fun getProductFlyEn(): Single<List<ProductFly>>
        fun getProductFlyRu(): Observable<List<ProductFly>>

        fun getProductLandEn(): Single<List<ProductLand>>
        fun getProductLandRu(): Single<List<ProductLand>>

//    fun getProductSkeleton(productSkeleton : ProductSkeleton): Single<List<ProductSkeleton>>

        fun getProductSwimEn(): Single<List<ProductSwim>>
        fun getProductSwimRu(): Single<List<ProductSwim>>
    }

    interface RoomRepository {
        //        fun insertFlyEn(note : FlyEntityEn) : Single<Boolean>
        fun insertFlyRu(entity: FlyEntityRu): Observable<Boolean>

        //        fun insertLandEn(note : LandEntityEn) : Single<Boolean>
//        fun insertLandRu(note : LandEntityRu) : Single<Boolean>
//        fun insertSwimEn(note : SwimEntityEn) : Single<Boolean>
//        fun insertSwimRu(note : SwimEntityRu) : Single<Boolean>
//
//        fun selectAllFlyEn() : Single<List<FlyEntityEn>>
        fun selectAllFlyRu(): Observable<List<FlyEntityRu>>
//        fun selectAllLandEn() : Single<List<LandEntityEn>>
//        fun selectAllLandRu() : Single<List<LandEntityRu>>
//        fun selectAllSwimEn() : Single<List<SwimEntityEn>>
//        fun selectAllSwimRu() : Single<List<SwimEntityRu>>
    }

}
package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Single

interface NetRepository {

    fun getProductFlyEn(): Single<List<ProductFly>>
    fun getProductFlyRu(): Single<List<ProductFly>>

    fun getProductLandEn(): Single<List<ProductLand>>
    fun getProductLandRu(): Single<List<ProductLand>>

//    fun getProductSkeleton(productSkeleton : ProductSkeleton): Single<List<ProductSkeleton>>

    fun getProductSwimEn(): Single<List<ProductSwim>>
    fun getProductSwimRu(): Single<List<ProductSwim>>

}
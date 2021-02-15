package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.api.RetrofitManager
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Single

class NetRepositoryImpl(private val netManager: RetrofitManager) : NetRepository {

    private val api by lazy { netManager.getApi() }

    override fun getProductFlyEn(): Single<List<ProductFly>> {
        return api.getFlyApiEn()
    }

    override fun getProductFlyRu(): Single<List<ProductFly>> {
        return api.getFlyApiRu()
    }

    override fun getProductLandEn(): Single<List<ProductLand>> {
        return api.getLandApiEn()
    }

    override fun getProductLandRu(): Single<List<ProductLand>> {
        return api.getLandApiRu()
    }

    override fun getProductSwimEn(): Single<List<ProductSwim>> {
        return api.getSwimApiEn()
    }

    override fun getProductSwimRu(): Single<List<ProductSwim>> {
        return api.getSwimApiRu()
    }

}
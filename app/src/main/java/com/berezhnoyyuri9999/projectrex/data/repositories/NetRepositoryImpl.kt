package com.berezhnoyyuri9999.projectrex.data.repositories


import com.berezhnoyyuri9999.projectrex.data.api.RetrofitManager
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single

class NetRepositoryImpl(private val netManager: RetrofitManager) :
    Repository.NetRepository {

    private val api by lazy { netManager.getApi() }

    override fun getProductFlyEn(): Observable<List<ProductFly>> {
        return api.getFlyApiEn()
    }

    override fun getProductFlyRu(): Observable<List<ProductFly>> {
        return api.getFlyApiRu()
    }

    override fun getProductLandEn(): Observable<List<ProductLand>> {
        return api.getLandApiEn()
    }

    override fun getProductLandRu(): Observable<List<ProductLand>> {
        return api.getLandApiRu()
    }

    override fun getProductSwimEn(): Observable<List<ProductSwim>> {
        return api.getSwimApiEn()
    }

    override fun getProductSwimRu(): Observable<List<ProductSwim>> {
        return api.getSwimApiRu()
    }

}

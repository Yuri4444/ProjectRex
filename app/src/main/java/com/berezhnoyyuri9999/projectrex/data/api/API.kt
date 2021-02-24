package com.berezhnoyyuri9999.projectrex.data.api

import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("v3/b674b5ce-78c1-41cc-a832-9528fae6d996")
    fun getFlyApiEn(): Single<List<ProductFly>>

    @GET("v3/6737e106-7206-45e9-9466-e1490b6bf0d6")
    fun getFlyApiRu(): Single<List<ProductFly>>

    @GET("v3/ddfb47d7-9229-43a0-96de-8b539d6f1ca9")
    fun getLandApiEn(): Single<List<ProductLand>>

    @GET("v3/9d7936b9-9cac-4b5d-80ac-6b4822efd299")
    fun getLandApiRu(): Single<List<ProductLand>>

    @GET("v3/e5a42244-cee2-4b0e-ac3f-0c22153e9cd9")
    fun getSwimApiEn(): Single<List<ProductSwim>>

    @GET("v3/4a79c952-0f8d-43a0-809c-aa796b59eaba")
    fun getSwimApiRu(): Single<List<ProductSwim>>


    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }

}
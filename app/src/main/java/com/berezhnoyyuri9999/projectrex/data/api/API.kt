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

    @GET("v3/8151e0a7-d64d-4e22-afe8-ee950c6b9272")
    fun getLandApiEn(): Single<List<ProductLand>>

    @GET("v3/39c1ac0c-d566-4a65-94c4-43c31b64ba39")
    fun getLandApiRu(): Single<List<ProductLand>>

    @GET("v3/e5a42244-cee2-4b0e-ac3f-0c22153e9cd9")
    fun getSwimApiEn(): Single<List<ProductSwim>>

    @GET("v3/4a79c952-0f8d-43a0-809c-aa796b59eaba")
    fun getSwimApiRu(): Single<List<ProductSwim>>


    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }

}
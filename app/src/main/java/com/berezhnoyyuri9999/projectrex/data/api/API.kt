package com.berezhnoyyuri9999.projectrex.data.api

import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface API {

    @GET("v3/6bc351bc-872c-4434-b222-c04e0238633a")
    fun getFlyApiEn(): Observable<List<ProductFly>>

    @GET("v3/91ba940d-3d42-4236-a506-fc631b488e45")
    fun getFlyApiRu(): Observable<List<ProductFly>>

    @GET("v3/9fcc3e0b-bb88-4065-9343-02cda50aa062")
    fun getLandApiEn(): Observable<List<ProductLand>>

    @GET("v3/18d53c92-dc60-4750-8413-b1586077b9b0")
    fun getLandApiRu(): Observable<List<ProductLand>>

    @GET("v3/8f42aad7-9f67-4df8-8f6b-a9895ac4c547")
    fun getSwimApiEn(): Observable<List<ProductSwim>>

    @GET("v3/1ddb21d3-f78a-44a9-b486-17a90800ec96")
    fun getSwimApiRu(): Observable<List<ProductSwim>>


    companion object {
        const val BASE_URL = "https://run.mocky.io/"
    }

}
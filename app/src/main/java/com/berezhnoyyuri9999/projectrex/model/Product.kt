package com.berezhnoyyuri9999.projectrex.model

import com.google.gson.annotations.SerializedName

data class Product (
        @SerializedName("titleRussian")
        val title: String,
        @SerializedName("photoUrlRussian")
        val photoUrl: String,
        @SerializedName("detailRussian")
        val detail: String,
        @SerializedName("description1Russian")
        val description1: String,
        @SerializedName("description2Russian")
        val description2: String,
        @SerializedName("takenRussian")
        val taken: String,

        @SerializedName("isOnSaleRussian")
        val isOnSale: Boolean,

        val rusCompare : String
)
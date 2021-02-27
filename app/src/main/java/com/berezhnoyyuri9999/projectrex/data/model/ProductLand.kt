package com.berezhnoyyuri9999.projectrex.data.model

data class ProductLand(
    val titleRussian: String,
    val photoUrlRussian: String,
    val detailRussian: String,
    val description1Russian: String,
    val description2Russian: String,
    val takenRussian: String,
    val isOnSaleRussian: Boolean,
    val rusCompare: String
)


fun ProductLand.toDino() = Dino(
    title = titleRussian,
    photoUrlRussian,
    detailRussian,
    description1Russian,
    description2Russian,
    takenRussian,
    rusCompare,
    "fly",
    isPredator = isOnSaleRussian
)
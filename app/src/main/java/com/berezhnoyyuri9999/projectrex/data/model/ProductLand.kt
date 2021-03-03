package com.berezhnoyyuri9999.projectrex.data.model

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

data class ProductLand(
    val titleRussian: String,
    val photoUrlRussian: String?,
    val detailRussian: String?,
    val description1Russian: String?,
    val description2Russian: String?,
    val takenRussian: String?,
    val isOnSaleRussian: Boolean?,
    val rusCompare: String?,
    val type : String?
)

fun ProductLand.toLocalEntity(): GlobalEntity {
    val result = GlobalEntity()
    result.title = titleRussian ?: ""
    result.photoUrl = photoUrlRussian ?: ""
    result.detail = detailRussian ?: ""
    result.description1 = description1Russian ?: ""
    result.description2 = description2Russian ?: ""
    result.taken = takenRussian ?: ""
    result.compare = rusCompare ?: ""
    result.isPredator = isOnSaleRussian ?: false
    result.type = type
    return result
}


fun ProductLand.toDino() = Dino(
    title = titleRussian,
    photoUrlRussian,
    detailRussian,
    description1Russian,
    description2Russian,
    takenRussian,
    rusCompare,
    "land",
    isPredator = false
)
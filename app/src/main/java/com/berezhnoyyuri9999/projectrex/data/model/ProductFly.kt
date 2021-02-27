package com.berezhnoyyuri9999.projectrex.data.model

import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu

data class ProductFly(
    val titleFly: String?,
    val photoUrlFly: String?,
    val detailFly: String?,
    val description1Fly: String?,
    val description2Fly: String?,
    val takenFly: String?,
    val compareFly: String?
)

fun ProductFly.toLocalEntity(): FlyEntityRu {
    val result = FlyEntityRu()
    result.titleFly = titleFly ?: ""
    result.photoUrlFly = photoUrlFly ?: ""
    result.detailFly = detailFly ?: ""
    result.description1Fly = description1Fly ?: ""
    result.description2Fly = description2Fly ?: ""
    result.takenFly = takenFly ?: ""
    result.compareFly = compareFly ?: ""
    return result
}

fun ProductFly.toDino() = Dino(
    title = titleFly,
    photoUrlFly,
    detailFly,
    description1Fly,
    description2Fly,
    takenFly,
    compareFly,
    "fly"
)

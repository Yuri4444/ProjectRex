package com.berezhnoyyuri9999.projectrex.data.model

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

data class ProductFly(
    val title: String,
    val photo: String?,
    val detail: String?,
    val description1: String?,
    val description2: String?,
    val taken: String?,
    val compare: String?,
    val type: String?
)

fun ProductFly.toLocalEntity(): GlobalEntity {
    val result = GlobalEntity()
    result.title = title?: ""
    result.photoUrl = photo ?: ""
    result.detail = detail ?: ""
    result.description1 = description1 ?: ""
    result.description2 = description2 ?: ""
    result.taken = taken ?: ""
    result.compare = compare ?: ""
    result.type = type ?: ""
    return result
}

fun ProductFly.toDino() = Dino(
    title = title,
    photo,
    detail,
    description1,
    description2,
    taken,
    compare,
    "fly"
)

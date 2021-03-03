package com.berezhnoyyuri9999.projectrex.data.model

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

data class ProductSwim (

        val titleSwim: String,
        val photoUrlSwim: String?,
        val detailSwim: String?,
        val description1Swim: String?,
        val description2Swim: String?,
        val takenSwim: String?,
        val type: String?
)

fun ProductSwim.toLocalEntity(): GlobalEntity {
        val result = GlobalEntity()
        result.title = titleSwim ?: ""
        result.photoUrl = photoUrlSwim ?: ""
        result.detail = detailSwim ?: ""
        result.description1 = description1Swim ?: ""
        result.description2 = description2Swim ?: ""
        result.taken = takenSwim ?: ""
        result.compare = "" ?: ""
        result.isPredator = false ?: false
        result.type = type ?: ""
        return result
}

fun ProductSwim.toDino() = Dino(
        title = titleSwim,
        photoUrlSwim,
        detailSwim,
        description1Swim,
        description2Swim,
        takenSwim,
        compare = "",
        "land",
        isPredator = false
)
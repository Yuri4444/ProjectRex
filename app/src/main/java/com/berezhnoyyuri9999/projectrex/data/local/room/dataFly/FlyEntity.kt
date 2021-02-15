package com.berezhnoyyuri9999.projectrex.data.local.room.dataFly

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fly_table")
data class FlyEntity(

    @PrimaryKey
    val id : Int = 0,

    @ColumnInfo
    val titleFly: String = "",

    @ColumnInfo
    val photoUrlFly: String = "",

    @ColumnInfo
    val detailFly: String = "",

    @ColumnInfo
    val description1Fly: String = "",

    @ColumnInfo
    val description2Fly: String = "",

    @ColumnInfo
    val takenFly: String = "",

    @ColumnInfo
    val compareFly: String = ""

)
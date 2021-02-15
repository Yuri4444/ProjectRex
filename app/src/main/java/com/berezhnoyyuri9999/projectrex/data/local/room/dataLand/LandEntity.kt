package com.berezhnoyyuri9999.projectrex.data.local.room.dataLand

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "land_table")
data class LandEntity(

    @PrimaryKey
    val id : Int = 0,

    @ColumnInfo
    val titleRussian: String = "",

    @ColumnInfo
    val photoUrlRussian: String = "",

    @ColumnInfo
    val detailRussian: String = "",

    @ColumnInfo
    val description1Russian: String = "",

    @ColumnInfo
    val description2Russian: String = "",

    @ColumnInfo
    val takenRussian: String = "",

    @ColumnInfo
    val isOnSaleRussian: Boolean = false,

    @ColumnInfo
    val rusCompare : String = ""



)
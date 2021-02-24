package com.berezhnoyyuri9999.projectrex.data.local.room.dataLand

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "land_table_en")
data class LandEntityEn(

    @PrimaryKey(autoGenerate = true)
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

) : Parcelable
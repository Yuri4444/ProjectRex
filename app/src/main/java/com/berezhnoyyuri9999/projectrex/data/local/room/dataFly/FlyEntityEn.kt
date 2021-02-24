package com.berezhnoyyuri9999.projectrex.data.local.room.dataFly

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fly_table_en")
data class FlyEntityEn(

    @PrimaryKey(autoGenerate = true)
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

) : Parcelable
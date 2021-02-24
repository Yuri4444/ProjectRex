package com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "swim_table_ru")
data class SwimEntityRu(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    @ColumnInfo
    val titleSwim: String = "",

    @ColumnInfo
    val photoUrlSwim: String = "",

    @ColumnInfo
    val detailSwim: String = "",

    @ColumnInfo
    val description1Swim: String = "",

    @ColumnInfo
    val description2Swim: String = "",

    @ColumnInfo
    val takenSwim: String = ""

) : Parcelable
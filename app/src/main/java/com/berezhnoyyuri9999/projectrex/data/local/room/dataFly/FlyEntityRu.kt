package com.berezhnoyyuri9999.projectrex.data.local.room.dataFly

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "fly_table_ru")
data class FlyEntityRu(
    @PrimaryKey
    @ColumnInfo
    var titleFly: String = "",

    @ColumnInfo
    var photoUrlFly: String = "",

    @ColumnInfo
    var detailFly: String = "",

    @ColumnInfo
    var description1Fly: String = "",

    @ColumnInfo
    var description2Fly: String = "",

    @ColumnInfo
    var takenFly: String = "",

    @ColumnInfo
    var compareFly: String = ""

) : Parcelable
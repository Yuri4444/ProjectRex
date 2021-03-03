package com.berezhnoyyuri9999.projectrex.data.local.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "global_table")
data class GlobalEntity(
        @PrimaryKey
        @ColumnInfo
        var title: String = "",
        @ColumnInfo
        var photoUrl: String? = "",
        @ColumnInfo
        var detail: String? = "",
        @ColumnInfo
        var description1: String? = "",
        @ColumnInfo
        var description2: String? = "",
        @ColumnInfo
        var taken: String? = "",
        @ColumnInfo
        var compare: String? = "",
        @ColumnInfo
        var type: String? = "",
        @ColumnInfo
        var isPredator: Boolean = false

) : Parcelable
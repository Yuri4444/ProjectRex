package com.berezhnoyyuri9999.projectrex.data.local.room.dataLand

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import io.reactivex.Observable


@Dao
interface LandDao {

    @Query("SELECT * FROM land_table")
    fun getAllLand() : Observable<List<LandEntity>>

    @Delete
    fun deleteLand(land : LandEntity)
}
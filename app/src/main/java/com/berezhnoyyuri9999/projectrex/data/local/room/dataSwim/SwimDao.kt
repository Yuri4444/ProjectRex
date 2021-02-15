package com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import io.reactivex.Observable


@Dao
interface SwimDao {

    @Query("SELECT * FROM swim_table")
    fun getAllSwim() : Observable<List<SwimEntity>>

    @Delete
    fun deleteSwim(swim : SwimEntity)
}
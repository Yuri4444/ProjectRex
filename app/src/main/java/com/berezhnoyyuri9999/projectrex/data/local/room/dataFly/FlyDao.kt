package com.berezhnoyyuri9999.projectrex.data.local.room.dataFly

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface FlyDao {

    @Query("SELECT * FROM fly_table")
    fun getAllFly() : Flowable<List<FlyEntity>>

    @Delete
    fun deleteFly(fly : FlyEntity)

}
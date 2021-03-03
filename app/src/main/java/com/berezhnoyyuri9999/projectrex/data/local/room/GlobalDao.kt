package com.berezhnoyyuri9999.projectrex.data.local.room

import androidx.room.*

@Dao
interface GlobalDao {
    //Fly En
    @Query("SELECT * FROM global_table where type = 'FlyEng'")
    fun getAllFlyEn() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToFlyEn(fly : GlobalEntity) : Long

    @Delete
    fun deleteFlyEn(fly : GlobalEntity)

//    ___________________
    //FlyRu
    @Query("SELECT * FROM global_table where type ='FlyRus'")
    fun getAllFlyRu() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToFlyRu(fly : GlobalEntity) : Long

    @Delete
    fun deleteFlyRu(fly : GlobalEntity)
////    ___________________
//
//    //LandEn
    @Query("SELECT * FROM global_table where type = 'landEn'")
    fun getAllLandEn() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToLandEn(land : GlobalEntity) : Long

    @Delete
    fun deleteLandEn(land : GlobalEntity)
////    ___________________
//
//    //LandRu
    @Query("SELECT * FROM global_table where type = 'landRu'")
    fun getAllLandRu() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToLandRu(land : GlobalEntity) : Long

    @Delete
    fun deleteLandRu(land : GlobalEntity)
////    ___________________
//
//    //SwimEn
    @Query("SELECT * FROM global_table where type = 'swimEn'")
    fun getAllSwimEn() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToSwimEn(swim : GlobalEntity) : Long

    @Delete
    fun deleteSwimEn(swim : GlobalEntity)
////    ___________________
//
//    //SwimRu
    @Query("SELECT * FROM global_table where type = 'swimRu'")
    fun getAllSwimRu() : List<GlobalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToSwimRu(swim : GlobalEntity) : Long

    @Delete
    fun deleteSwimRu(swim : GlobalEntity)
}
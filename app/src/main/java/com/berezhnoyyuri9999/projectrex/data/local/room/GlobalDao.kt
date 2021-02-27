package com.berezhnoyyuri9999.projectrex.data.local.room

import androidx.room.*
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityRu


@Dao
interface GlobalDao {
    //Fly En
//    @Query("SELECT * FROM fly_table_en")
//    fun getAllFlyEn() : List<FlyEntityEn>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertToFlyEn(fly : FlyEntityEn) : Long
//
//    @Delete
//    fun deleteFlyEn(fly : FlyEntityEn)

//    ___________________
    //FlyRu
    @Query("SELECT * FROM fly_table_ru")
    fun getAllFlyRu() : List<FlyEntityRu>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToFlyRu(fly : FlyEntityRu) : Long

    @Delete
    fun deleteFlyRu(fly : FlyEntityRu)
////    ___________________
//
//    //LandEn
//    @Query("SELECT * FROM land_table_en")
//    fun getAllLandEn() : List<LandEntityEn>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertToLandEn(land : LandEntityEn) : Long
//
//    @Delete
//    fun deleteLandEn(land : LandEntityEn)
////    ___________________
//
//    //LandRu
//    @Query("SELECT * FROM land_table_ru")
//    fun getAllLandRu() : List<LandEntityRu>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertToLandRu(land : LandEntityRu) : Long
//
//    @Delete
//    fun deleteLandRu(land : LandEntityRu)
////    ___________________
//
//    //SwimEn
//    @Query("SELECT * FROM swim_table_en")
//    fun getAllSwimEn() : List<SwimEntityEn>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertToSwimEn(swim : SwimEntityEn) : Long
//
//    @Delete
//    fun deleteSwimEn(swim : SwimEntityEn)
////    ___________________
//
//    //SwimRu
//    @Query("SELECT * FROM swim_table_ru")
//    fun getAllSwimRu() : List<SwimEntityRu>
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    fun insertToSwimRu(swim : SwimEntityRu) : Long
//
//    @Delete
//    fun deleteSwimRu(swim : SwimEntityRu)
}
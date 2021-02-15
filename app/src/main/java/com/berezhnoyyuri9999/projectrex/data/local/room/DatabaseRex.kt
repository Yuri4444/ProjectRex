package com.berezhnoyyuri9999.projectrex.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyDao
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntity
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandDao
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntity
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimDao
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntity

@Database(entities = [FlyEntity::class, LandEntity::class, SwimEntity::class],
    version = 1, exportSchema = false)
abstract class DatabaseRex : RoomDatabase() {

    abstract fun getFlyDao() : FlyDao

    abstract fun getLandDao() : LandDao

    abstract fun getSwimDao() : SwimDao

    companion object {

        @Volatile
        private var database : DatabaseRex? = null

        @Synchronized
        fun getInstance(context: Context?) : DatabaseRex {

            return if(database == null) {
                database = Room.databaseBuilder(
                    context!!,
                    DatabaseRex::class.java,
                    "database Rex"
                ).build()
                database as DatabaseRex
            } else
                database as DatabaseRex
        }
    }
}
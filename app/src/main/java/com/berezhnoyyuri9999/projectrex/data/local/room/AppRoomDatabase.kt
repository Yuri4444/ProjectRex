package com.berezhnoyyuri9999.projectrex.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [GlobalEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getAppRoomDao(): GlobalDao

    companion object {

        @Volatile
        private var database: AppRoomDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppRoomDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    AppRoomDatabase::class.java,
                    "database"
                ).build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase

        }
    }


}
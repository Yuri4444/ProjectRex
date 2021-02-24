package com.berezhnoyyuri9999.projectrex

import android.app.Application
import android.content.Context
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.api.RetrofitManager
import com.berezhnoyyuri9999.projectrex.data.local.room.AppRoomDatabase
import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRepository
import com.berezhnoyyuri9999.projectrex.data.repositories.NetRepositoryImpl
import com.berezhnoyyuri9999.projectrex.data.repositories.Repository

class RexClass : Application(), App {

    private val net by lazy { NetRepositoryImpl(RetrofitManager(this)) }
    private lateinit var database: DatabaseRepository


    override fun onCreate() {
        super.onCreate()

        val dao = AppRoomDatabase.getInstance(this).getAppRoomDao()
        database = DatabaseRepository(dao)
    }

    override fun getNetRepository() : Repository.NetRepository = net

    override fun getRoomRepository(): DatabaseRepository = database

    companion object {
        fun getApp(context: Context?): App {
            return context?.applicationContext as App
        }
    }

}
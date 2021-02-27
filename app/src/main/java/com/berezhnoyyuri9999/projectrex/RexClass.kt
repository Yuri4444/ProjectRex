package com.berezhnoyyuri9999.projectrex

import android.app.Application
import android.content.Context
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.api.RetrofitManager
import com.berezhnoyyuri9999.projectrex.data.local.room.AppRoomDatabase
import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRepository
import com.berezhnoyyuri9999.projectrex.data.repositories.NetRepositoryImpl
import com.berezhnoyyuri9999.projectrex.data.repositories.Repository
import com.berezhnoyyuri9999.projectrex.data.repositories.RepositoryImpl

class RexClass : Application(), App {

    private val net by lazy { NetRepositoryImpl(RetrofitManager(this)) }
    lateinit var database: DatabaseRepository
    private lateinit var repository: Repository


    override fun onCreate() {
        super.onCreate()

        val dao = AppRoomDatabase.getInstance(this).getAppRoomDao()
        database = DatabaseRepository(dao)
        repository = RepositoryImpl(database, net)
    }

    override fun getNetRepository(): Repository.NetRepository = net

    override fun getRoomRepository(): DatabaseRepository = database

    override fun getRepository(): Repository = repository

    companion object {
        fun getApp(context: Context?): App {
            return context?.applicationContext as App
        }
    }

}
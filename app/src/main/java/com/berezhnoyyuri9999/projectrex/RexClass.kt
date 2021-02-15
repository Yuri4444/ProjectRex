package com.berezhnoyyuri9999.projectrex

import android.app.Application
import android.content.Context
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.repositories.NetRepository
import com.berezhnoyyuri9999.projectrex.data.repositories.NetRepositoryImpl
import com.berezhnoyyuri9999.projectrex.data.api.RetrofitManager

class RexClass : Application(), App {

    private val net by lazy { NetRepositoryImpl(RetrofitManager(this)) }

    override fun getNetRepository() : NetRepository = net
    companion object {
        fun getApp(context: Context?): App {
            return context?.applicationContext as RexClass
        }
    }
}
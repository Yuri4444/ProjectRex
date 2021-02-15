package com.berezhnoyyuri9999.projectrex.data.repositories.fly

import android.content.Context
import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRex
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyDao
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntity
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import io.reactivex.Flowable

class RepositoryFly(context : Context?) {

    private var mFlyDao : FlyDao? = null
    private val db : DatabaseRex = DatabaseRex.getInstance(context)

    init {
        mFlyDao = db.getFlyDao()
    }

    fun getRxFly() : Flowable <List<FlyEntity>> {
        return mFlyDao!!.getAllFly()
    }

    fun getDb(context : Context?) : DatabaseRex {
        return db ?: DatabaseRex.getInstance(context)
    }

    fun closeDb() {
        db.close()
    }

}
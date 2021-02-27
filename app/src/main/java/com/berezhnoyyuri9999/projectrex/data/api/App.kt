package com.berezhnoyyuri9999.projectrex.data.api


import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRepository
import com.berezhnoyyuri9999.projectrex.data.repositories.Repository

interface App {

    fun getNetRepository(): Repository.NetRepository

    fun getRoomRepository() : DatabaseRepository

    fun getRepository(): Repository

}
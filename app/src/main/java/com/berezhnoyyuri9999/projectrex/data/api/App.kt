package com.berezhnoyyuri9999.projectrex.data.api

import com.berezhnoyyuri9999.projectrex.data.repositories.NetRepository

interface App {

    fun getNetRepository(): NetRepository

}
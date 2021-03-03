package com.berezhnoyyuri9999.projectrex.domain.services

import com.berezhnoyyuri9999.projectrex.data.api.App
import io.reactivex.schedulers.Schedulers

class Interactor(private val app: App) {

    private val net by lazy { app.getNetRepository() }

    private val repository by lazy { app.getRepository() }

    fun getFlyEn() = repository.getFlyEnDinos()
        .subscribeOn(Schedulers.io())

    fun getFlyRu() = repository.getFlyRuDinos()
        .subscribeOn(Schedulers.io())

    fun getLandEn() = repository.getLandEnDinos()
        .subscribeOn(Schedulers.io())

    fun getLandRu() = repository.getLandRuDinos()
        .subscribeOn(Schedulers.io())

    fun getSwimEn() = repository.getSwimEnDinos()
        .subscribeOn(Schedulers.io())
    fun getSwimRu() = repository.getSwimRuDinos()
        .subscribeOn(Schedulers.io())

}

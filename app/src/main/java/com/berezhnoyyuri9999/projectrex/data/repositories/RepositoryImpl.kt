package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRepository
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.berezhnoyyuri9999.projectrex.data.model.toDino
import com.berezhnoyyuri9999.projectrex.data.model.toLocalEntity
import io.reactivex.Observable

class RepositoryImpl(
    val local: DatabaseRepository,
    val remote: Repository.NetRepository
) : Repository {
    override fun getFlyEnDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductFlyEn()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertFlyEn(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllFlyEn() }
    }

    override fun getFlyRuDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductFlyRu()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertFlyRu(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllFlyRu() }
//        1) сходить в локалку
//        2) сходить на сервер и обновить локалку
//        3) после обновления локальных данных -- выдать обновленные данные
    }

    override fun getLandEnDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductLandEn()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertLandEn(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllLandEn() }
    }

    override fun getLandRuDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductLandRu()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertLandRu(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllLandRu() }
    }

    override fun getSwimEnDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductSwimEn()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertSwimEn(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllSwimEn() }
    }

    override fun getSwimRuDinos(): Observable<List<GlobalEntity>> {
        return remote.getProductSwimRu()
            .map { remoteData ->
                val dinos = remoteData.map { it.toDino() }.toList()
                remoteData
            }
            .map { remoteData ->
                remoteData.map { it.toLocalEntity() }.toList()
            }
            .flatMapIterable { it }
            .flatMap { local.insertSwimRu(it) }
            .toList()
            .toObservable()
            .flatMap { local.selectAllSwimRu() }
    }


}
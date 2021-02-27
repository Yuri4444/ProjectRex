package com.berezhnoyyuri9999.projectrex.data.repositories

import com.berezhnoyyuri9999.projectrex.data.local.room.DatabaseRepository
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.data.model.toDino
import com.berezhnoyyuri9999.projectrex.data.model.toLocalEntity
import io.reactivex.Observable

class RepositoryImpl(
    val local: DatabaseRepository,
    val remote: Repository.NetRepository
) : Repository {

    override fun getFlyDinos(): Observable<List<FlyEntityRu>> {
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
}
package com.berezhnoyyuri9999.projectrex.data.local.room

import com.berezhnoyyuri9999.projectrex.data.repositories.Repository
import io.reactivex.Observable


class DatabaseRepository(private val glDao: GlobalDao) : Repository.RoomRepository {

    override fun insertFlyEn(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToFlyRu(entity) }
            .map { it > 1 }

    override fun insertFlyRu(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToFlyRu(entity) }
            .map { it > 1 }

    override fun insertLandEn(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToLandEn(entity) }
            .map { it > 1 }

    override fun insertLandRu(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToLandRu(entity) }
            .map { it > 1 }

    override fun insertSwimEn(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToSwimEn(entity) }
            .map { it > 1 }

    override fun insertSwimRu(entity: GlobalEntity): Observable<Boolean> =
        Observable.fromCallable { glDao.insertToSwimRu(entity) }
            .map { it > 1 }

    override fun selectAllFlyEn(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllFlyEn() }

    override fun selectAllFlyRu(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllFlyRu() }

    override fun selectAllLandEn(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllLandEn() }

    override fun selectAllLandRu(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllLandRu() }

    override fun selectAllSwimEn(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllSwimEn() }

    override fun selectAllSwimRu(): Observable<List<GlobalEntity>> =
        Observable.fromCallable { glDao.getAllSwimRu() }

}
package com.berezhnoyyuri9999.projectrex.data.local.room

import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataLand.LandEntityRu
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityEn
import com.berezhnoyyuri9999.projectrex.data.local.room.dataSwim.SwimEntityRu
import com.berezhnoyyuri9999.projectrex.data.repositories.Repository
import io.reactivex.Single


class DatabaseRepository(private val glDao: GlobalDao) : Repository.RoomRepository {
    override fun insertFlyEn(note: FlyEntityEn): Single<Boolean> =
        Single.fromCallable { glDao.insertToFlyEn(note) }
            .map { it > 1 }

    override fun insertFlyRu(note: FlyEntityRu): Single<Boolean> =
        Single.fromCallable { glDao.insertToFlyRu(note) }
            .map { it > 1 }

    override fun insertLandEn(note: LandEntityEn): Single<Boolean> =
        Single.fromCallable { glDao.insertToLandEn(note) }
            .map { it > 1 }

    override fun insertLandRu(note: LandEntityRu): Single<Boolean> =
        Single.fromCallable { glDao.insertToLandRu(note) }
            .map { it > 1 }

    override fun insertSwimEn(note: SwimEntityEn): Single<Boolean> =
        Single.fromCallable { glDao.insertToSwimEn(note) }
            .map { it > 1 }

    override fun insertSwimRu(note: SwimEntityRu): Single<Boolean> =
        Single.fromCallable { glDao.insertToSwimRu(note) }
            .map { it > 1 }

    override fun selectAllFlyEn(): Single<List<FlyEntityEn>> =
        Single.fromCallable { glDao.getAllFlyEn() }

    override fun selectAllFlyRu(): Single<List<FlyEntityRu>> =
        Single.fromCallable { glDao.getAllFlyRu() }


    override fun selectAllLandEn(): Single<List<LandEntityEn>> =
        Single.fromCallable { glDao.getAllLandEn() }


    override fun selectAllLandRu(): Single<List<LandEntityRu>> =
        Single.fromCallable { glDao.getAllLandRu() }


    override fun selectAllSwimEn(): Single<List<SwimEntityEn>> =
        Single.fromCallable { glDao.getAllSwimEn() }


    override fun selectAllSwimRu(): Single<List<SwimEntityRu>> =
        Single.fromCallable { glDao.getAllSwimRu() }

}
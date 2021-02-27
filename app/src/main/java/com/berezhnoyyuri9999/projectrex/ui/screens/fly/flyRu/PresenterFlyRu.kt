package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyRu

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterFlyRu(var app: App) : FlyContract.FlyPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: FlyContract.FlyView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {
        interactor.getFlyRu()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("SUCCESS", it.toString())
                view?.showFly(it)
            }, {
                Log.e("ERROR", it.message ?: "")
            })

//        interactor.getFlyRu()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                view?.showFly(it)
//            }, {
//
//            })
    }

    override fun bindView(view: FlyContract.FlyView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

    override fun addDataToDb(list: FlyEntityEn) {

    }


}
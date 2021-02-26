package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyEn

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import io.reactivex.android.schedulers.AndroidSchedulers

class PresenterFlyEn(app : App) : FlyContract.FlyPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: FlyContract.FlyView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getFlyEn()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showFly(it)
            }, {
                Log.e("Error", "${it.message}")
            })

    }

    override fun bindView(view: FlyContract.FlyView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

    @SuppressLint("CheckResult")
    override fun addDataToDb(list: FlyEntityEn) {
        interactor.insertFlyEn(list)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            }, {

            })
    }

}
package com.berezhnoyyuri9999.projectrex.ui.screens.land.landEn

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterLandEn(app : App) : LandContract.LandPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view : LandContract.LandView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getLandEn()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("SUCCESS", it.toString())
                view?.showLand(it)
            }, {
                Log.e("ERROR", it.message ?: "")
            })

        }

    override fun bindView(view: LandContract.LandView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

}

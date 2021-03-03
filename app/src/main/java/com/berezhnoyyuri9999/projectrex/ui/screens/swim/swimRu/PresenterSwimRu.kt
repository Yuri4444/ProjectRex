package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimRu

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterSwimRu(app : App) : SwimContract.SwimPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: SwimContract.SwimView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getSwimRu()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("SUCCESS", it.toString())
                view?.showSwim(it)
            }, {
                Log.e("ERROR", it.message ?: "")
            })

    }

    override fun bindView(view: SwimContract.SwimView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }
}
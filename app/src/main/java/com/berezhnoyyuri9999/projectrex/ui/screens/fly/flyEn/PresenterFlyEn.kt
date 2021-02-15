package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyEn

import android.annotation.SuppressLint
import android.util.Log
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.repositories.fly.RepositoryFly
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PresenterFlyEn(app : App) : FlyContract.FlyPresenter {

    private var mRepositoryFly : RepositoryFly? = null

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


}
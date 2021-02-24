package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyRu

import android.annotation.SuppressLint
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_fly_russian.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PresenterFlyRu(app: App) : FlyContract.FlyPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view: FlyContract.FlyView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getFlyRu()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showFly(it)
            }, {

            })
    }

    override fun bindView(view: FlyContract.FlyView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }


}
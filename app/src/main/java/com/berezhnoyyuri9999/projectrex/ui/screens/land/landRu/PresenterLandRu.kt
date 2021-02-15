package com.berezhnoyyuri9999.projectrex.ui.screens.land.landRu

import android.annotation.SuppressLint
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PresenterLandRu(app : App) : LandContract.LandPresenter {

    private val interactor by lazy {
        Interactor(app)
    }



    @SuppressLint("CheckResult")
    override fun fetch() {
        interactor.getLandRu()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showLand(it)
            },{

            })
    }

    override fun bindView(view: LandContract.LandView) {
        this.view = view

    }

    private var view : LandContract.LandView? = null

    override fun unBindView() {
        this.view = null
    }
}

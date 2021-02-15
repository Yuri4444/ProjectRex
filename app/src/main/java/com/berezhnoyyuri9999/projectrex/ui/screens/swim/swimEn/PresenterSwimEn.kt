package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimEn

import android.annotation.SuppressLint
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimContract
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_swim.*
import kotlinx.android.synthetic.main.fragment_swim.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PresenterSwimEn(app : App) : SwimContract.SwimPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view : SwimContract.SwimView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getSwimEn()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showSwim(it)
            }, {

            })
    }

    override fun bindView(view: SwimContract.SwimView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

}
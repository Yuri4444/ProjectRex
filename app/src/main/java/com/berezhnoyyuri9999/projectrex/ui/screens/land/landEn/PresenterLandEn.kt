package com.berezhnoyyuri9999.projectrex.ui.screens.land.landEn

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.data.api.App
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.domain.services.Interactor
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PresenterLandEn(app : App) : LandContract.LandPresenter {

    private val interactor by lazy {
        Interactor(app)
    }

    private var view : LandContract.LandView? = null

    @SuppressLint("CheckResult")
    override fun fetch() {

        interactor.getLandEn()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.showLand(it)
            },{

            })
        }

    override fun bindView(view: LandContract.LandView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }

}

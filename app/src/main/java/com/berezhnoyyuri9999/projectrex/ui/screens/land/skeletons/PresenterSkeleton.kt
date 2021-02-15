package com.berezhnoyyuri9999.projectrex.ui.screens.land.skeletons

import com.berezhnoyyuri9999.projectrex.data.model.ProductSkeleton
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_skelet.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class PresenterSkeleton : SkeletonContract.SkeletonPresenter {

    private var view : SkeletonContract.SkeletonView? = null

    override fun fetch() {
        doAsync {
            val jsonSkeleton = URL("https://run.mocky.io/v3/4e768d1a-8992-4e0c-b80b-c51053fed58d").readText()

            uiThread {
                val productsSkeleton = Gson().fromJson(jsonSkeleton, Array<ProductSkeleton>::class.java).toList()
                view?.showSkeleton(productsSkeleton)
            }
        }
    }

    override fun bindView(view: SkeletonContract.SkeletonView) {
        this.view = view
    }

    override fun unBindView() {
        this.view = null
    }
}
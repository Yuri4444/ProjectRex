package com.berezhnoyyuri9999.projectrex.ui.screens.swim

import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim

interface SwimContract {
    interface SwimView {
        fun showSwim(list: List<ProductSwim>)
        fun showLoader()
    }

    interface SwimPresenter {
        fun fetch()
        fun bindView(view: SwimView)
        fun unBindView()
    }
}
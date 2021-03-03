package com.berezhnoyyuri9999.projectrex.ui.screens.swim

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

interface SwimContract {
    interface SwimView {
        fun showSwim(list: List<GlobalEntity>)
        fun showLoader()
    }

    interface SwimPresenter {
        fun fetch()
        fun bindView(view: SwimView)
        fun unBindView()
    }
}
package com.berezhnoyyuri9999.projectrex.ui.screens.fly

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

interface FlyContract {
    interface FlyView {
        fun showFly(list: List<GlobalEntity>)
        fun showLoader()
    }

    interface FlyPresenter {
        fun fetch()
        fun bindView(view : FlyView)
        fun unBindView()
    }
}
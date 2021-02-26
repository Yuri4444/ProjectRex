package com.berezhnoyyuri9999.projectrex.ui.screens.fly

import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityEn
import com.berezhnoyyuri9999.projectrex.data.model.ProductFly

interface FlyContract {
    interface FlyView {
        fun showFly(list: List<ProductFly>)
        fun showLoader()
    }

    interface FlyPresenter {
        fun fetch()
        fun bindView(view : FlyView)
        fun unBindView()
        fun addDataToDb(list: FlyEntityEn)

    }
}
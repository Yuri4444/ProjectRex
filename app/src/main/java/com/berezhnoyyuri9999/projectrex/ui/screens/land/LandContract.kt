package com.berezhnoyyuri9999.projectrex.ui.screens.land

import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity

interface LandContract {
   interface LandView {
       fun showLand(list : List<GlobalEntity>)
       fun showLoading()
   }

    interface LandPresenter {
        fun fetch()
        fun bindView(view : LandView)
        fun unBindView()
    }




}
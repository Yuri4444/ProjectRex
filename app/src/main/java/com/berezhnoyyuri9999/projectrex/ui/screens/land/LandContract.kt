package com.berezhnoyyuri9999.projectrex.ui.screens.land

import com.berezhnoyyuri9999.projectrex.data.model.ProductLand

interface LandContract {
   interface LandView {
       fun showLand(list : List<ProductLand>)
       fun showLoading()
   }

    interface LandPresenter {
        fun fetch()
        fun bindView(view : LandView)
        fun unBindView()
    }




}
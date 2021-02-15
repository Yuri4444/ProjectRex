package com.berezhnoyyuri9999.projectrex.ui.screens.land.skeletons

import com.berezhnoyyuri9999.projectrex.data.model.ProductSkeleton

interface SkeletonContract {
    interface SkeletonView {
        fun showSkeleton(list: List<ProductSkeleton>)
        fun showLoading()
    }

    interface SkeletonPresenter {
        fun fetch()
        fun bindView(view : SkeletonView)
        fun unBindView()
    }
}
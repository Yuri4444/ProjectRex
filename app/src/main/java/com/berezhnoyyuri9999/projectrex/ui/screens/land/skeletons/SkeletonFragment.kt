package com.berezhnoyyuri9999.projectrex.ui.screens.land.skeletons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.model.ProductSkeleton
import kotlinx.android.synthetic.main.fragment_skelet.*

class SkeletonFragment : Fragment(), SkeletonContract.SkeletonView {

    private val presenterSkeleton by lazy {
        PresenterSkeleton()
    }

    private val skeletonAdapter by lazy {
        SkeletonAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_skelet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSkeleton.layoutManager = LinearLayoutManager(activity)
        recyclerViewSkeleton.adapter = skeletonAdapter
        presenterSkeleton.fetch()
    }

    override fun onStart() {
        super.onStart()
        presenterSkeleton.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterSkeleton.unBindView()
    }

    override fun showSkeleton(list: List<ProductSkeleton>) {
        skeletonAdapter.setData(list)
    }

    override fun showLoading() {

    }

}
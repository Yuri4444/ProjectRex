package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyEn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass

import com.berezhnoyyuri9999.projectrex.data.model.ProductFly
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import kotlinx.android.synthetic.main.fragment_fly.*

class FlyEnglishFragment : Fragment(), FlyContract.FlyView {

    private val presenterFlyEn by lazy {
        PresenterFlyEn(RexClass.getApp(context))
    }

    private val flyAdapter by lazy {
        FlyAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_fly, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewFly.layoutManager = LinearLayoutManager(activity)
        recyclerViewFly.adapter = flyAdapter
        presenterFlyEn.fetch()
    }

    override fun onStart() {
        super.onStart()
        presenterFlyEn.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterFlyEn.unBindView()
    }

    override fun showFly(list: List<ProductFly>) {
        flyAdapter.setData(list)
    }

    override fun showLoader() {

    }

}


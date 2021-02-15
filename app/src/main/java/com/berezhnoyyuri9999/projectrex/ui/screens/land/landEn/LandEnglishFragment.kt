package com.berezhnoyyuri9999.projectrex.ui.screens.land.landEn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import kotlinx.android.synthetic.main.fragment_main.*

class LandEnglishFragment : Fragment(), LandContract.LandView {

    private val presenterLandEn by lazy {
        PresenterLandEn(RexClass.getApp(context))
    }

    private val russianAdapter by lazy {
        LandAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = russianAdapter

        presenterLandEn?.fetch()

    }

    override fun onStart() {
        super.onStart()

        presenterLandEn?.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterLandEn?.unBindView()
    }

    override fun showLand(list: List<ProductLand>) {
        showLoading()
        russianAdapter.setData(list)
    }

    override fun showLoading() {
        progressBar.visibility = View.GONE
    }


}
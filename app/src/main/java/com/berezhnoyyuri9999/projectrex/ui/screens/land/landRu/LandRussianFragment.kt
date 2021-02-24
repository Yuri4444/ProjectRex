package com.berezhnoyyuri9999.projectrex.ui.screens.land.landRu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.model.ProductLand
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import kotlinx.android.synthetic.main.fragment_russian.*
//https://ru.freepik.com/vectors/background
class LandRussianFragment : Fragment(), LandContract.LandView {

    private val presenterLandRu by lazy {
        PresenterLandRu(RexClass.getApp(context))
    }

    private val russianAdapter by lazy {
        LandAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_russian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_viewRussian.layoutManager = LinearLayoutManager(activity)
        recycler_viewRussian.adapter = russianAdapter

        presenterLandRu.fetch()

    }

    override fun onStart() {
        super.onStart()

        presenterLandRu.bindView(this)

    }

    override fun onStop() {
        super.onStop()
        presenterLandRu.unBindView()
    }

    override fun showLand(list: List<ProductLand>) {
        showLoading()
        russianAdapter.setData(list)
    }

    override fun showLoading() {
        progressBarRussian.visibility = View.GONE
    }
}

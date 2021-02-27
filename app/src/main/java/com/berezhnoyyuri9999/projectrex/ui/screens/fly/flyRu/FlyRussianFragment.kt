package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyRu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import kotlinx.android.synthetic.main.fragment_fly_russian.*

class FlyRussianFragment : Fragment(), FlyContract.FlyView {

    private val presenterFlyRu by lazy {
        PresenterFlyRu(RexClass.getApp(context))
    }

    private val flyAdapter by lazy {
        FlyAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val flyRussian = inflater.inflate(R.layout.fragment_fly_russian, container, false)

        return flyRussian
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_viewFlyRussian.layoutManager = LinearLayoutManager(activity)
        recycler_viewFlyRussian.adapter = flyAdapter
        presenterFlyRu.fetch()

    }

    override fun onStart() {
        super.onStart()
        presenterFlyRu.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterFlyRu.unBindView()
    }

    override fun showFly(list: List<FlyEntityRu>) {
        showLoader()
        flyAdapter.setData(list)
    }

    override fun showLoader() {
        warningFlyF.visibility = View.INVISIBLE
    }



}
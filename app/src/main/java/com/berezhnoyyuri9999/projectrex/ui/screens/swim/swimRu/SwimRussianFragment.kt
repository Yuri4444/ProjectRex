package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimRu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.model.ProductSwim
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimContract
import kotlinx.android.synthetic.main.fragment_swim_russian.*

class SwimRussianFragment : Fragment(), SwimContract.SwimView {

    private val presenterSwimRu by lazy {
        PresenterSwimRu(RexClass.getApp(context))
    }

    private val swimAdapter by lazy {
        SwimAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_swim_russian, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_viewSwimRussian.layoutManager = LinearLayoutManager(activity)
        recycler_viewSwimRussian.adapter = swimAdapter
        presenterSwimRu.fetch()

    }

    override fun onStart() {
        super.onStart()
        presenterSwimRu.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterSwimRu.unBindView()
    }

    override fun showSwim(list: List<ProductSwim>) {
        swimAdapter.setData(list)
    }

    override fun showLoader() {

    }


}
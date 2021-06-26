package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyRu

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.berezhnoyyuri9999.projectrex.details.FlyActivityDetails
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import kotlinx.android.synthetic.main.activity_fly_details.*
import kotlinx.android.synthetic.main.fragment_fly_russian.*
import kotlinx.android.synthetic.main.product_row_fly.*

class FlyRussianFragment : Fragment(), FlyContract.FlyView {

    private val presenterFlyRu by lazy {
        PresenterFlyRu(RexClass.getApp(context))
    }

    private val flyAdapter by lazy {
        FlyAdapter { _, item ->
            val intent = Intent(context, FlyActivityDetails::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("detail", item.detail)
            intent.putExtra("description1", item.description1)
            intent.putExtra("description2", item.description2)
            intent.putExtra("photo_url", item.photoUrl)
            intent.putExtra("photoCompare", item.compare)
            intent.putExtra("taken", item.taken)
            startActivity(intent)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_fly_russian, container, false)
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

    override fun showFly(list: List<GlobalEntity>) {
        showLoader()
        flyAdapter.setData(list)
    }

    override fun showLoader() {
        warningFlyF.visibility = View.INVISIBLE
    }



}
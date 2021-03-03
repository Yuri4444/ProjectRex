package com.berezhnoyyuri9999.projectrex.ui.screens.fly.flyEn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.MainActivity
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.berezhnoyyuri9999.projectrex.details.FlyActivityDetails
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.fly.FlyContract
import kotlinx.android.synthetic.main.activity_fly_details.*
import kotlinx.android.synthetic.main.fragment_fly.*
import kotlinx.android.synthetic.main.product_row_fly.*
import kotlinx.android.synthetic.main.product_row_fly.photoFly

class FlyEnglishFragment : Fragment(), FlyContract.FlyView {

    private val presenterFlyEn by lazy {
        PresenterFlyEn(RexClass.getApp(context))
    }

    private val flyAdapter by lazy {
        FlyAdapter { pos, item ->
            val intent = Intent(context, FlyActivityDetails::class.java)
            intent.putExtra("titleFly", item.title)
            intent.putExtra("detailFly", item.detail)
            intent.putExtra("description1Fly", item.description1)
            intent.putExtra("description2Fly", item.description2)
            intent.putExtra("photo_urlFly", item.photoUrl)
            intent.putExtra("photoCompare", item.compare)
            intent.putExtra("takenFly", item.taken)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

    override fun showFly(list: List<GlobalEntity>) {
        showLoader()
        flyAdapter.setData(list)
    }

    override fun showLoader() {
        warningFly.visibility = View.INVISIBLE
    }

}


package com.berezhnoyyuri9999.projectrex.ui.screens.land.landEn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.MainActivity
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.RexClass
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.berezhnoyyuri9999.projectrex.details.ProductDetails
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.land.LandContract
import kotlinx.android.synthetic.main.fragment_land.*

class LandEnglishFragment : Fragment(), LandContract.LandView {

    private val presenterLandEn by lazy {
        PresenterLandEn(RexClass.getApp(context))
    }

    private val russianAdapter by lazy {
        LandAdapter { pos, item ->
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra("title", item.title)
            intent.putExtra("detail", item.detail)
            intent.putExtra("description1", item.description1)
            intent.putExtra("description2", item.description2)
            intent.putExtra("photo_url", item.photoUrl)
            intent.putExtra("taken", item.taken)
            intent.putExtra("photoCompare", item.compare)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_land, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = russianAdapter

        presenterLandEn.fetch()

    }

    override fun onStart() {
        super.onStart()

        presenterLandEn.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterLandEn.unBindView()
    }

    override fun showLand(list: List<GlobalEntity>) {
        showLoading()
        russianAdapter.setData(list)
    }

    override fun showLoading() {
        progressBar.visibility = View.GONE
    }


}
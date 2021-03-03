package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimEn

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
import com.berezhnoyyuri9999.projectrex.details.SwimActivityDetails
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimAdapter
import com.berezhnoyyuri9999.projectrex.ui.screens.swim.SwimContract
import kotlinx.android.synthetic.main.fragment_swim.*

class SwimEnglishFragment : Fragment(), SwimContract.SwimView {

    private val presenterSwimEn by lazy {
        PresenterSwimEn(RexClass.getApp(context))
    }

    private val swimAdapter by lazy {
        SwimAdapter { pos, item ->
            val intent = Intent(context, SwimActivityDetails::class.java)
            intent.putExtra("titleSwim", item.title)
            intent.putExtra("detailSwim", item.detail)
            intent.putExtra("description1Swim", item.description1)
            intent.putExtra("description2Swim", item.description2)
            intent.putExtra("photo_urlSwim", item.photoUrl)
            intent.putExtra("takenSwim", item.taken)
            startActivity(intent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_swim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewSwim.layoutManager = LinearLayoutManager(activity)
        recyclerViewSwim.adapter = swimAdapter

        presenterSwimEn.fetch()
    }

    override fun onStart() {
        super.onStart()
        presenterSwimEn.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterSwimEn.unBindView()
    }

    override fun showSwim(list: List<GlobalEntity>) {
        showLoader()
        swimAdapter.setData(list)
    }

    override fun showLoader() {
        warningSwim.visibility = View.INVISIBLE
    }

}


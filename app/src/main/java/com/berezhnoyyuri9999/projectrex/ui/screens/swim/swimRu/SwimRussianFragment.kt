package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimRu

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
import kotlinx.android.synthetic.main.fragment_swim_russian.*

class SwimRussianFragment : Fragment(), SwimContract.SwimView {

    private val presenterSwimRu by lazy {
        PresenterSwimRu(RexClass.getApp(context))
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

    override fun showSwim(list: List<GlobalEntity>) {
        showLoader()
        swimAdapter.setData(list)
    }

    override fun showLoader() {
        warningSwimR.visibility = View.INVISIBLE
    }

}
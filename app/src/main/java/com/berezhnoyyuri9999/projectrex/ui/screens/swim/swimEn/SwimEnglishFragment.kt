package com.berezhnoyyuri9999.projectrex.ui.screens.swim.swimEn
//https://run.mocky.io/v3/29a9352e-0e82-4222-8a95-7cbce2935d9a
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
import kotlinx.android.synthetic.main.fragment_swim.*

//typealias kotlin
class SwimEnglishFragment : Fragment(), SwimContract.SwimView {

    private val presenterSwimEn by lazy {
        PresenterSwimEn(RexClass.getApp(context))
    }

    private val swimAdapter by lazy {
        SwimAdapter()
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

        presenterSwimEn?.fetch()
    }

    override fun onStart() {
        super.onStart()
        presenterSwimEn?.bindView(this)
    }

    override fun onStop() {
        super.onStop()
        presenterSwimEn?.unBindView()
    }

    override fun showSwim(list: List<ProductSwim>) {
        swimAdapter.setData(list)
    }

    override fun showLoader() {

    }

}


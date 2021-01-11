package com.berezhnoyyuri9999.projectrex.cardSwim
//https://run.mocky.io/v3/29a9352e-0e82-4222-8a95-7cbce2935d9a
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.adapters.SwimAdapter
import com.berezhnoyyuri9999.projectrex.model.ProductSwim
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fly.view.*
import kotlinx.android.synthetic.main.fragment_swim.*
import kotlinx.android.synthetic.main.fragment_swim.view.*
import kotlinx.android.synthetic.main.main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL
//typealias kotlin
class SwimFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootSwim = inflater.inflate(R.layout.fragment_swim, container, false)

        doAsync {
            val jsonSwim = URL("https://run.mocky.io/v3/b4adaa0d-f6e2-4df6-b0bf-b2dfcc20bc8f").readText()

            uiThread {
                val productsSwim = Gson().fromJson(jsonSwim, Array<ProductSwim>::class.java).toList()

                recyclerViewSwim.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = SwimAdapter(productsSwim)
                    rootSwim.worningSwim.visibility = View.GONE


                }

            }
        }

        return rootSwim
    }

}


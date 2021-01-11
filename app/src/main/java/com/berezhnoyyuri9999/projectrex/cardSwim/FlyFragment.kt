package com.berezhnoyyuri9999.projectrex.cardSwim

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.adapters.FlyAdapter
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.model.ProductFly
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fly.view.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class FlyFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootFly = inflater.inflate(R.layout.fragment_fly, container, false)

        doAsync {
            val jsonFly = URL("https://run.mocky.io/v3/34055265-3e3b-4451-b847-af42c4d74b2e").readText()

            uiThread {
                val productsFly = Gson().fromJson(jsonFly, Array<ProductFly>::class.java).toList()

                rootFly.recyclerViewFly.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = FlyAdapter(productsFly)
                    rootFly.worningFly.visibility = View.GONE
                }
            }
        }


        return rootFly
    }

}


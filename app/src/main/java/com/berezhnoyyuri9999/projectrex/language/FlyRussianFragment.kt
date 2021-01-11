package com.berezhnoyyuri9999.projectrex.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.adapters.FlyAdapter
import com.berezhnoyyuri9999.projectrex.adapters.SwimAdapter
import com.berezhnoyyuri9999.projectrex.model.ProductFly
import com.berezhnoyyuri9999.projectrex.model.ProductSwim
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fly.view.*
import kotlinx.android.synthetic.main.fragment_fly_russian.*
import kotlinx.android.synthetic.main.fragment_fly_russian.view.*
import kotlinx.android.synthetic.main.fragment_swim_russian.*
import kotlinx.android.synthetic.main.fragment_swim_russian.recycler_viewSwimRussian
import kotlinx.android.synthetic.main.fragment_swim_russian.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class FlyRussianFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val flyRussian = inflater.inflate(R.layout.fragment_fly_russian, container, false)

        doAsync {
            val jsonFly = URL("https://run.mocky.io/v3/c75c665d-a4bb-4ba1-a900-25a78f2a149e").readText()

            uiThread {
                val productsFly = Gson().fromJson(jsonFly, Array<ProductFly>::class.java).toList()

                flyRussian.recycler_viewFlyRussian.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = FlyAdapter(productsFly)
                    flyRussian.worningFlyF.visibility = View.GONE
                }
            }
        }

        return flyRussian
    }

}
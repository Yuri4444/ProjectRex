package com.berezhnoyyuri9999.projectrex.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.adapters.RussianAdapter
import com.berezhnoyyuri9999.projectrex.adapters.SwimAdapter
import com.berezhnoyyuri9999.projectrex.model.ProductRussian
import com.berezhnoyyuri9999.projectrex.model.ProductSwim
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_russian.view.*
import kotlinx.android.synthetic.main.fragment_swim.*
import kotlinx.android.synthetic.main.fragment_swim.view.*
import kotlinx.android.synthetic.main.fragment_swim_russian.*
import kotlinx.android.synthetic.main.fragment_swim_russian.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class SwimRussianFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val swimRussian = inflater.inflate(R.layout.fragment_swim_russian, container, false)
        doAsync {
            val jsonSwim = URL("https://run.mocky.io/v3/f0626a90-b25c-46cb-b933-a2da4ab9a934").readText()

            uiThread {
                val productsSwim = Gson().fromJson(jsonSwim, Array<ProductSwim>::class.java).toList()

                recycler_viewSwimRussian.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = SwimAdapter(productsSwim)
                    swimRussian.worningSwimR.visibility = View.GONE


                }

            }
        }

        return swimRussian
    }


}
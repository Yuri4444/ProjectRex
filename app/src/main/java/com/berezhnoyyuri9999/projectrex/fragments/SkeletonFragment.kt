package com.berezhnoyyuri9999.projectrex.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.adapters.SkeletonAdapter
import com.berezhnoyyuri9999.projectrex.model.ProductSkeleton
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_fly.view.*
import kotlinx.android.synthetic.main.fragment_skelet.*
import kotlinx.android.synthetic.main.fragment_skelet.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class SkeletonFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootSkeleton = inflater.inflate(R.layout.fragment_skelet, container, false)

        doAsync {
            val jsonSkeleton = URL("https://run.mocky.io/v3/4e768d1a-8992-4e0c-b80b-c51053fed58d").readText()

            uiThread {
                val productsSkeleton = Gson().fromJson(jsonSkeleton, Array<ProductSkeleton>::class.java).toList()

                rootSkeleton.recyclerViewSkeleton.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = SkeletonAdapter(productsSkeleton)
//                    root.progressBar.visibility = View.GONE
                }
            }
        }




        return rootSkeleton
    }

}
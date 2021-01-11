package com.berezhnoyyuri9999.projectrex.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.adapters.ProductsAdapter
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.model.Product
import com.google.gson.Gson
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
//        https://run.mocky.io/v3/696233b3-07b4-458f-a674-c30cb6f02d4f
        doAsync {
            val json =
                URL("https://run.mocky.io/v3/c5a159dc-a2d6-41ef-8fbb-8fa6c895bfae").readText()

            uiThread {
                val products = Gson().fromJson(json, Array<Product>::class.java).toList()

                root.recycler_view.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = ProductsAdapter(products)
                    root.progressBar.visibility = View.GONE
                }
            }
        }


//        root.progressBar.visibility= View.GONE


        return root
    }


}
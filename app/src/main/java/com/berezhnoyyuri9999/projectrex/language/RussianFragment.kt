package com.berezhnoyyuri9999.projectrex.language

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.adapters.RussianAdapter
import com.berezhnoyyuri9999.projectrex.model.ProductRussian
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_russian.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL
//https://ru.freepik.com/vectors/background
class RussianFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootRussian = inflater.inflate(R.layout.fragment_russian, container, false)
//        https://run.mocky.io/v3/265c5024-6091-41d8-9a46-339569e5f1e7
        doAsync {
            val json = URL("https://run.mocky.io/v3/66dc0ff6-0b34-4688-9393-e6fe758d3e48").readText()

            uiThread {
                val productsRussian = Gson().fromJson(json, Array<ProductRussian>::class.java).toList()

                rootRussian.recycler_viewRussian.apply {
                    layoutManager = LinearLayoutManager(activity)

                    adapter = RussianAdapter(productsRussian)
                    rootRussian.progressBarRussian.visibility = View.GONE
                }
            }
        }

        return rootRussian
    }

}

//,
//
//
//
//{
//    "titleRussian" : "",
//    "photoUrlRussian" : "",
//    "detailRussian" : "Поздний меловой период\n3 метр\n8 метра\n2 тонн\n2002 год,  Китай\nРезцовая ящерица",
//    "description1Russian" : "",
//    "description2Russian" : "",
//    "takenRussian" : "Картинка взята из источника -
//    Текст взят из источника -
//    ",
//    "isOnSaleRussian" : false
//}


//https://scontent.fhrk1-1.fna.fbcdn.net/v/t1.0-9/fr/cp0/e15/q65/129897147_108141944490186_1552865924291874269_n.jpg?_
// nc_cat=103&ccb=2&_nc_sid=0be424&efg=eyJpIjoidCJ9&_nc_ohc=AwUoqcwnbpQAX-BLY9a&_nc_ht=scontent.fhrk1-1.fna&tp=14&oh=dda7bf435141f473
// c4de8c692e7ae22b&oe=6020AB10
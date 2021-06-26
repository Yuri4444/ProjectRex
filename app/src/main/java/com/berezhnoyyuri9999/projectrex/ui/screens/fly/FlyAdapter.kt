package com.berezhnoyyuri9999.projectrex.ui.screens.fly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.squareup.picasso.Picasso

class FlyAdapter(private var clickListener: (Int, GlobalEntity) -> Unit) :
    RecyclerView.Adapter<FlyAdapter.ViewHolder>() {

    private val productsSwim: MutableList<GlobalEntity> = ArrayList()

    fun setData(newLine: List<GlobalEntity>) {
        productsSwim.clear()
        productsSwim.addAll(newLine)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productSwim = productsSwim[position]
        Picasso.get().load(productsSwim[position].photoUrl).into(holder.imageFly)

        holder.titleFly.text = productSwim.title

        holder.itemView.setOnClickListener {
            clickListener.invoke(holder.adapterPosition, productsSwim[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_row_fly, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = productsSwim.size

    class ViewHolder(itemViewFly: View) : RecyclerView.ViewHolder(itemViewFly) {
        var imageFly: ImageView
        var titleFly: TextView

        init {
            imageFly = itemViewFly.findViewById(R.id.photoFly)
            titleFly = itemViewFly.findViewById(R.id.titleFly)
        }

    }
}

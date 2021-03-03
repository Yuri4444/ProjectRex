package com.berezhnoyyuri9999.projectrex.ui.screens.swim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.squareup.picasso.Picasso

class SwimAdapter(val clickListener: (Int, GlobalEntity) -> Unit) : RecyclerView.Adapter<SwimAdapter.ViewHolder>() {

    private val productsSwim: MutableList<GlobalEntity> = ArrayList()

    fun setData(newList: List<GlobalEntity>) {
        productsSwim.clear()
        productsSwim.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productSwim = productsSwim[position]
        Picasso.get().load(productSwim.photoUrl).into(holder.imageSwim)
        holder.titleSwim.text = productSwim.title
        holder.detailsSwim.text = productSwim.detail
        holder.description1Swim.text = productSwim.description1
        holder.description2Swim.text = productSwim.description2
        holder.takenSwim.text = productSwim.taken

        holder.itemView.setOnClickListener {
            clickListener.invoke(holder.adapterPosition, productsSwim[holder.adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewSwim = LayoutInflater.from(parent.context).inflate(R.layout.product_row_swim, parent, false)

        return ViewHolder(viewSwim)
    }

    override fun getItemCount() = productsSwim.size

    class ViewHolder(itemViewSwim: View) : RecyclerView.ViewHolder(itemViewSwim) {
        val imageSwim: ImageView = itemViewSwim.findViewById(R.id.photoSwim)
        val titleSwim: TextView = itemViewSwim.findViewById(R.id.titleSwim)
        val detailsSwim: TextView = itemViewSwim.findViewById(R.id.detailSwim)
        val description1Swim: TextView = itemViewSwim.findViewById(R.id.description1Swim)
        val description2Swim: TextView = itemViewSwim.findViewById(R.id.description2Swim)
        val takenSwim: TextView = itemViewSwim.findViewById(R.id.takenSwim)

    }
}
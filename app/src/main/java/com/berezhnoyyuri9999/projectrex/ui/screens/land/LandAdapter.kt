package com.berezhnoyyuri9999.projectrex.ui.screens.land

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.local.room.GlobalEntity
import com.squareup.picasso.Picasso

class LandAdapter(var clickListener: (Int, GlobalEntity) -> Unit)
    : RecyclerView.Adapter<LandAdapter.ViewHolder>() {

    private val productsLand : MutableList<GlobalEntity> = ArrayList()

    fun setData(newList : List<GlobalEntity>) {
        productsLand.clear()
        productsLand.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsLand[position]
        Picasso.get().load(productsLand[position].photoUrl).into(holder.image)
        Picasso.get().load(productsLand[position].compare).into(holder.imageCompareRus)

        holder.title.text = product.title
        holder.detail.text = product.detail
        holder.description1.text = product.description1
        holder.description2.text = product.description2

        holder.taken.text = product.taken

        holder.itemView.setOnClickListener {
            clickListener.invoke(holder.adapterPosition, productsLand[holder.adapterPosition])
        }
        
        if (product.isPredator) {
            holder.isOnSale.setImageResource(R.drawable.plato1r)
        } else {
            holder.isOnSale.setImageResource(R.drawable.travo1r)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = productsLand.size

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val detail: TextView = itemView.findViewById(R.id.detail)
        val description1: TextView = itemView.findViewById(R.id.description1)
        val description2: TextView = itemView.findViewById(R.id.description2)
        val taken : TextView = itemView.findViewById(R.id.taken)
        val isOnSale : ImageView = itemView.findViewById(R.id.saleImageView)
        val imageCompareRus : ImageView = itemView.findViewById(R.id.im_compareMain)

    }
}
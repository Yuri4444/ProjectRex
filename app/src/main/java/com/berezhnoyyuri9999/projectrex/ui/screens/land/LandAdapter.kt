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

class LandAdapter(private var clickListener: (Int, GlobalEntity) -> Unit) :
    RecyclerView.Adapter<LandAdapter.ViewHolder>() {

    private val productsLand: MutableList<GlobalEntity> = ArrayList()

    fun setData(newList: List<GlobalEntity>) {
        productsLand.clear()
        productsLand.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsLand[position]
        Picasso.get().load(productsLand[position].photoUrl).into(holder.image)

        holder.title.text = product.title
        holder.itemView.setOnClickListener {
            clickListener.invoke(holder.adapterPosition, productsLand[holder.adapterPosition])
        }

        if (product.isPredator) {
            holder.isPredator.setImageResource(R.drawable.plato1r)
        } else {
            holder.isPredator.setImageResource(R.drawable.travo1r)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = productsLand.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var title: TextView
        var isPredator: ImageView

        init {
            image = itemView.findViewById(R.id.photo)
            title = itemView.findViewById(R.id.title)
            isPredator = itemView.findViewById(R.id.imIsPredator)

        }

    }
}
package com.berezhnoyyuri9999.projectrex.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.details.SwimActivityDetails
import com.berezhnoyyuri9999.projectrex.model.ProductSwim
import com.squareup.picasso.Picasso

class SwimAdapter(private val productsSwim: List<ProductSwim>) : RecyclerView.Adapter<SwimAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productSwim = productsSwim[position]
        Picasso.get().load(productsSwim[position].photoUrlSwim).into(holder.imageSwim)
        holder.titleSwim.text = productSwim.titleSwim
        holder.detailsSwim.text = productSwim.detailSwim
        holder.description1Swim.text = productSwim.description1Swim
        holder.description2Swim.text = productSwim.description2Swim

        holder.takenSwim.text = productSwim.takenSwim
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewSwim = LayoutInflater.from(parent.context).inflate(R.layout.product_row_swim, parent, false)
        val holderSwim = ViewHolder(viewSwim)
        /////
        viewSwim.setOnClickListener {
            val intent = Intent(parent.context, SwimActivityDetails::class.java)
            intent.putExtra("titleSwim", productsSwim[holderSwim.adapterPosition].titleSwim)
            intent.putExtra("detailSwim", productsSwim[holderSwim.adapterPosition].detailSwim)
            intent.putExtra("description1Swim", productsSwim[holderSwim.adapterPosition].description1Swim)
            intent.putExtra("description2Swim", productsSwim[holderSwim.adapterPosition].description2Swim)
            intent.putExtra("photo_urlSwim", productsSwim[holderSwim.adapterPosition].photoUrlSwim)

            intent.putExtra("takenSwim", productsSwim[holderSwim.adapterPosition].takenSwim)

            parent.context.startActivity(intent)
        }

        /////

        return holderSwim
    }

    override fun getItemCount() = productsSwim.size

    class ViewHolder(itemViewSwim: View) : RecyclerView.ViewHolder(itemViewSwim) {
        val imageSwim : ImageView = itemViewSwim.findViewById(R.id.photoSwim)
        val titleSwim : TextView = itemViewSwim.findViewById(R.id.titleSwim)
        val detailsSwim : TextView = itemViewSwim.findViewById(R.id.detailSwim)
        val description1Swim : TextView = itemViewSwim.findViewById(R.id.description1Swim)
        val description2Swim : TextView = itemViewSwim.findViewById(R.id.description2Swim)
        val takenSwim : TextView = itemViewSwim.findViewById(R.id.takenSwim)

    }
}
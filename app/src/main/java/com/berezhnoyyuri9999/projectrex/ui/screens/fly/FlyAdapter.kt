package com.berezhnoyyuri9999.projectrex.ui.screens.fly

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.local.room.dataFly.FlyEntityRu
import com.berezhnoyyuri9999.projectrex.details.FlyActivityDetails
import com.squareup.picasso.Picasso

class FlyAdapter : RecyclerView.Adapter<FlyAdapter.ViewHolder>() {

    private val productsFly = mutableListOf<FlyEntityRu>()

    fun setData(newLine: List<FlyEntityRu>) {
        productsFly.clear()
        productsFly.addAll(newLine)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productSwim = productsFly[position]
        Picasso.get().load(productsFly[position].photoUrlFly).into(holder.imageFly)
        Picasso.get().load(productsFly[position].compareFly).into(holder.imageCompareFly)

        holder.titleFly.text = productSwim.titleFly
        holder.detailsFly.text = productSwim.detailFly
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewFly =
            LayoutInflater.from(parent.context).inflate(R.layout.product_row_fly, parent, false)
        val holderFly = ViewHolder(viewFly)

        viewFly.setOnClickListener {
            val intent = Intent(parent.context, FlyActivityDetails::class.java)
            intent.putExtra("titleFly", productsFly[holderFly.adapterPosition].titleFly)
            intent.putExtra("detailFly", productsFly[holderFly.adapterPosition].detailFly)
            intent.putExtra(
                "description1Fly",
                productsFly[holderFly.adapterPosition].description1Fly
            )
            intent.putExtra(
                "description2Fly",
                productsFly[holderFly.adapterPosition].description2Fly
            )
            intent.putExtra("photo_urlFly", productsFly[holderFly.adapterPosition].photoUrlFly)
            intent.putExtra("photoCompare", productsFly[holderFly.adapterPosition].compareFly)
            intent.putExtra("takenFly", productsFly[holderFly.adapterPosition].takenFly)
            parent.context.startActivity(intent)
        }

        return holderFly
    }

    override fun getItemCount() = productsFly.size

    class ViewHolder(itemViewFly: View) : RecyclerView.ViewHolder(itemViewFly) {
        val imageFly: ImageView = itemViewFly.findViewById(R.id.photoFly)
        val titleFly: TextView = itemViewFly.findViewById(R.id.titleFly)
        val detailsFly: TextView = itemViewFly.findViewById(R.id.detailFly)
        val imageCompareFly: ImageView = itemViewFly.findViewById(R.id.im_compareFly)

    }
}

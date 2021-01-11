package com.berezhnoyyuri9999.projectrex.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.details.ProductDetails
import com.berezhnoyyuri9999.projectrex.model.Product
import com.berezhnoyyuri9999.projectrex.model.ProductRussian
import com.squareup.picasso.Picasso

class RussianAdapter (private val productsRussian : List<ProductRussian>) : RecyclerView.Adapter<RussianAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsRussian[position]
        Picasso.get().load(productsRussian[position].photoUrlRussian).into(holder.image)
        //
        Picasso.get().load(productsRussian[position].rusCompare).into(holder.imageCompareRus)
        //
        holder.title.text = product.titleRussian
        holder.detail.text = product.detailRussian
        holder.description1.text = product.description1Russian
        holder.description2.text = product.description2Russian

        holder.taken.text = product.takenRussian
        
        if (product.isOnSaleRussian) {
            holder.isOnSale.setImageResource(R.drawable.plato1r)
        } else {
            holder.isOnSale.setImageResource(R.drawable.travo1r)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holderRussian = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, ProductDetails::class.java)
            intent.putExtra("title", productsRussian[holderRussian.adapterPosition].titleRussian)
            intent.putExtra("detail", productsRussian[holderRussian.adapterPosition].detailRussian)
            intent.putExtra("description1", productsRussian[holderRussian.adapterPosition].description1Russian)
            intent.putExtra("description2", productsRussian[holderRussian.adapterPosition].description2Russian)
            intent.putExtra("photo_url", productsRussian[holderRussian.adapterPosition].photoUrlRussian)

            intent.putExtra("taken", productsRussian[holderRussian.adapterPosition].takenRussian)
            /////////
            intent.putExtra("photoCompare", productsRussian[holderRussian.adapterPosition].rusCompare)
            /////////

            parent.context.startActivity(intent)
        }
        return holderRussian
    }

    override fun getItemCount() = productsRussian.size

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val detail: TextView = itemView.findViewById(R.id.detail)
        val description1: TextView = itemView.findViewById(R.id.description1)
        val description2: TextView = itemView.findViewById(R.id.description2)

        val taken : TextView = itemView.findViewById(R.id.taken)

        val isOnSale : ImageView = itemView.findViewById(R.id.saleImageView)

        //
        val imageCompareRus : ImageView = itemView.findViewById(R.id.im_compareMain)
        //
    }
}
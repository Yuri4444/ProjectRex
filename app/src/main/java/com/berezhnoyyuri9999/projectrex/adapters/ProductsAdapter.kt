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
import com.squareup.picasso.Picasso

class ProductsAdapter(private val products : List<Product>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        Picasso.get().load(products[position].photoUrl).into(holder.image)
        //
        Picasso.get().load(products[position].rusCompare).into(holder.imageCompareRus)
        //
        holder.title.text = product.title
        holder.detail.text = product.detail
        holder.description1.text = product.description1
        holder.description2.text = product.description2

        holder.taken.text = product.taken


        if (product.isOnSale) {
            holder.isOnSale.setImageResource(R.drawable.plato1r)
        } else {
            holder.isOnSale.setImageResource(R.drawable.travo1r)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, ProductDetails::class.java)
            intent.putExtra("title", products[holder.adapterPosition].title)
            intent.putExtra("detail", products[holder.adapterPosition].detail)
            intent.putExtra("description1", products[holder.adapterPosition].description1)
            intent.putExtra("description2", products[holder.adapterPosition].description2)
            intent.putExtra("photo_url", products[holder.adapterPosition].photoUrl)

            intent.putExtra("taken", products[holder.adapterPosition].taken)

            /////////
            intent.putExtra("photoCompare", products[holder.adapterPosition].rusCompare)
            /////////

            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount() = products.size

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
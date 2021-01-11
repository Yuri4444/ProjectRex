package com.berezhnoyyuri9999.projectrex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.model.ProductSkeleton
import com.squareup.picasso.Picasso

class SkeletonAdapter(private val productsSkeleton : List<ProductSkeleton>) : RecyclerView.Adapter<SkeletonAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productSkeleton = productsSkeleton[position]

        holder.titleSkeleton.text = productSkeleton.titleSkeleton
        Picasso.get().load(productsSkeleton[position].photoUrlSkeleton).into(holder.imageSkeleton)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewSkeleton = LayoutInflater.from(parent.context).inflate(R.layout.product_row_skeletons, parent, false)

        return ViewHolder(viewSkeleton)
    }
    override fun getItemCount() = productsSkeleton.size

    class ViewHolder(itemViewSkeleton: View) : RecyclerView.ViewHolder(itemViewSkeleton) {
        val imageSkeleton : ImageView = itemViewSkeleton.findViewById(R.id.photoSkeleton)
        val titleSkeleton : TextView = itemViewSkeleton.findViewById(R.id.titleSkeleton)
    }

}
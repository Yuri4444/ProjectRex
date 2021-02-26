package com.berezhnoyyuri9999.projectrex.ui.screens.menuFragments.records

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.berezhnoyyuri9999.projectrex.R
import com.berezhnoyyuri9999.projectrex.data.model.ListRecords
import com.squareup.picasso.Picasso

class AdapterRecords : RecyclerView.Adapter<AdapterRecords.ViewHolder>() {

    private val recordList : MutableList<ListRecords> = ArrayList()

    fun setData(newList : List<ListRecords>) {
        recordList.clear()
        recordList.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.titleRecord)
        val description : TextView = itemView.findViewById(R.id.descriptionRecord)
        val image : ImageView = itemView.findViewById(R.id.imageRecord)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_records, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recordPosition = recordList[position]
        holder.title.text = recordPosition.title
        holder.description.text = recordPosition.description
        Picasso.get().load(recordPosition.image).into(holder.image)

    }

    override fun getItemCount(): Int = recordList.size


}
package com.example.omcellular5 // Make sure this matches your package name

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// A new data class to hold both text and an icon
data class RepairItem(val name: String, val iconResId: Int)

class RepairAdapter(private val repairList: List<RepairItem>) :
    RecyclerView.Adapter<RepairAdapter.RepairViewHolder>() {

    class RepairViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val repairIcon: ImageView = itemView.findViewById(R.id.repair_icon)
        val repairName: TextView = itemView.findViewById(R.id.repair_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepairViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_repair, parent, false)
        return RepairViewHolder(view)
    }

    override fun onBindViewHolder(holder: RepairViewHolder, position: Int) {
        val item = repairList[position]
        holder.repairName.text = item.name
        holder.repairIcon.setImageResource(item.iconResId)
    }

    override fun getItemCount() = repairList.size
}
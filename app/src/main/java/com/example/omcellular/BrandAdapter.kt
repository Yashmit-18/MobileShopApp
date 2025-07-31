package com.example.omcellular5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Brand(val name: String, val logoUrl: String)

class BrandAdapter(private val brandList: List<Brand>) : RecyclerView.Adapter<BrandAdapter.BrandViewHolder>() {

    class BrandViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandLogo: ImageView = itemView.findViewById(R.id.brand_logo)
        val brandName: TextView = itemView.findViewById(R.id.brand_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_brand, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val brand = brandList[position]
        holder.brandName.text = brand.name
        Glide.with(holder.itemView.context).load(brand.logoUrl).into(holder.brandLogo)

        // --- THIS IS THE NEW CLICK LISTENER ---
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ModelSelectionActivity::class.java).apply {
                // Pass the selected brand name to the next activity
                putExtra("BRAND_NAME", brand.name)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = brandList.size
}
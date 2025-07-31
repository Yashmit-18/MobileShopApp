package com.example.omcellular5

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.product_image)
        val name: TextView = itemView.findViewById(R.id.product_name)
        val specs: TextView = itemView.findViewById(R.id.product_specs)
        val price: TextView = itemView.findViewById(R.id.product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.name
        holder.specs.text = product.specs
        holder.price.text = product.price
        Glide.with(holder.itemView.context).load(product.imageUrl).into(holder.image)

        // --- ADD THIS CLICK LISTENER ---
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetailActivity::class.java).apply {
                // Pass all the product data to the detail activity
                putExtra("PRODUCT_NAME", product.name)
                putExtra("PRODUCT_SPECS", product.specs)
                putExtra("PRODUCT_PRICE", product.price)
                putExtra("PRODUCT_IMAGE_URL", product.imageUrl)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = productList.size
}
package com.example.omcellular5

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        // Find views
        val toolbar: Toolbar = findViewById(R.id.toolbar_detail)
        val imageView: ImageView = findViewById(R.id.iv_product_image_detail)
        val nameView: TextView = findViewById(R.id.tv_product_name_detail)
        val specsView: TextView = findViewById(R.id.tv_product_specs_detail)
        val priceView: TextView = findViewById(R.id.tv_product_price_detail)
        val buyNowButton: Button = findViewById(R.id.btn_buy_now)

        // Get data from Intent
        val name = intent.getStringExtra("PRODUCT_NAME")
        val specs = intent.getStringExtra("PRODUCT_SPECS")
        val price = intent.getStringExtra("PRODUCT_PRICE")
        val imageUrl = intent.getStringExtra("PRODUCT_IMAGE_URL")

        // Set up the toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.title = name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Populate the views with data
        nameView.text = name
        specsView.text = specs
        priceView.text = price
        Glide.with(this).load(imageUrl).into(imageView)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
package com.example.omcellular5 // Make sure this matches your package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        val toolbar: Toolbar = findViewById(R.id.toolbar_sell)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView: RecyclerView = findViewById(R.id.brands_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val brandList = listOf(
            Brand("Apple", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1667px-Apple_logo_black.svg.png"),
            // THIS IS THE CORRECTED URL FOR SAMSUNG
            Brand("Samsung", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Samsung_Logo.svg/1024px-Samsung_Logo.svg.png"),
            Brand("OnePlus", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/OnePlus_logo.svg/2560px-OnePlus_logo.svg.png"),
            Brand("Google", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Google_2015_logo.svg/2560px-Google_2015_logo.svg.png"),
            Brand("Xiaomi", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ae/Xiaomi_logo_%282021-%29.svg/2048px-Xiaomi_logo_%282021-%29.svg.png")
        )
        val adapter = BrandAdapter(brandList)
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
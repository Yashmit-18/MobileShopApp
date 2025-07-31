package com.example.omcellular5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ModelSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_model_selection)

        val toolbar: Toolbar = findViewById(R.id.toolbar_model)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val brandName = intent.getStringExtra("BRAND_NAME")
        supportActionBar?.title = "Select $brandName Model"

        val recyclerView: RecyclerView = findViewById(R.id.models_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val modelList = when (brandName) {
            "Apple" -> listOf("iPhone 15 Pro Max", "iPhone 15", "iPhone 14 Pro", "iPhone 14", "iPhone 13")
            "Samsung" -> listOf("Galaxy S24 Ultra", "Galaxy S23", "Galaxy Z Fold 5", "Galaxy A54")
            "OnePlus" -> listOf("OnePlus 12", "OnePlus 11R", "OnePlus Nord 3", "OnePlus 10 Pro")
            "Google" -> listOf("Pixel 8 Pro", "Pixel 8a", "Pixel 7a", "Pixel 7")
            "Xiaomi" -> listOf("Xiaomi 14", "Redmi Note 13 Pro", "Poco F6", "Xiaomi 13 Pro")
            else -> listOf()
        }

        recyclerView.adapter = ModelAdapter(modelList)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
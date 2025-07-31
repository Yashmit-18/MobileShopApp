package com.example.omcellular5 // Make sure this matches your package name

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.omcellular5.databinding.ActivityBuyBinding // Use View Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BuyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuyBinding // Setup View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setSupportActionBar(binding.toolbarBuy)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Fetch the list of all products from Firestore
        fetchProductsForSale()
    }

    private fun fetchProductsForSale() {
        binding.buyRecyclerView.layoutManager = LinearLayoutManager(this)

        val db = Firebase.firestore
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                // This code runs if the data is fetched successfully
                val productList = result.toObjects(Product::class.java)
                binding.buyRecyclerView.adapter = ProductAdapter(productList)
            }
            .addOnFailureListener { exception ->
                // This code runs if there is an error
                Log.w("FirestoreError", "Error getting documents.", exception)
                Toast.makeText(this, "Failed to load products.", Toast.LENGTH_SHORT).show()
            }
    }

    // Handles back button press in toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
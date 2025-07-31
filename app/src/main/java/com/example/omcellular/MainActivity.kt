package com.example.omcellular5 // Make sure this matches your package name

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.omcellular5.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val sliderHandler = Handler(Looper.getMainLooper())
    private lateinit var sliderRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Om Cellular"

        setupSlider()
        setupButtonClickListeners()
        fetchFeaturedPhones()
    }

    private fun fetchFeaturedPhones() {
        binding.productsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val db = Firebase.firestore
        db.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = result.toObjects(Product::class.java)
                binding.productsRecyclerView.adapter = ProductAdapter(productList)
            }
            .addOnFailureListener { exception ->
                Log.w("FirestoreError", "Error getting documents.", exception)
                Toast.makeText(this, "Failed to load products.", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setupSlider() {
        val sliderImages = listOf(
            "https://images.cashify.in/image/upload/v1633609174/Web-Banner_Buy_Desktop.png",
            "https://images.cashify.in/image/upload/v1633609221/Web-Banner_Sell_Desktop.png",
            "https://images.cashify.in/image/upload/v1633609259/Web-Banner_Repair_Desktop.png"
        )
        binding.viewPagerSlider.adapter = SliderAdapter(sliderImages, binding.viewPagerSlider)
        binding.dotsIndicator.attachTo(binding.viewPagerSlider)

        sliderRunnable = Runnable {
            var currentItem = binding.viewPagerSlider.currentItem
            currentItem++
            if (currentItem >= sliderImages.size) {
                currentItem = 0
            }
            binding.viewPagerSlider.setCurrentItem(currentItem, true)
        }

        binding.viewPagerSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })
    }

    private fun setupButtonClickListeners() {
        binding.cardBuy.setOnClickListener { startActivityWithAnimation(Intent(this, BuyActivity::class.java)) }
        binding.cardSell.setOnClickListener { startActivityWithAnimation(Intent(this, SellActivity::class.java)) }
        binding.cardRepair.setOnClickListener { startActivityWithAnimation(Intent(this, RepairActivity::class.java)) }
        binding.cardContact.setOnClickListener { startActivityWithAnimation(Intent(this, ContactActivity::class.java)) }
    }

    private fun startActivityWithAnimation(intent: Intent) {
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }
}
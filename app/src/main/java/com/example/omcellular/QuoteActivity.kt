package com.example.omcellular5

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import java.util.Locale

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        val finalPrice = intent.getIntExtra("FINAL_PRICE", 0)
        val priceTextView: TextView = findViewById(R.id.tv_final_price)

        val format = NumberFormat.getCurrencyInstance(Locale("en", "IN"))
        priceTextView.text = format.format(finalPrice)
    }
}
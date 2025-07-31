package com.example.omcellular5 // Make sure this matches your package name

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Setup Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar_contact)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Find the TextViews by their IDs from the layout
        val addressTextView: TextView = findViewById(R.id.tv_address)
        val phoneTextView: TextView = findViewById(R.id.tv_phone_number)

        // Set a click listener for the address
        addressTextView.setOnClickListener {
            // Create a Uri for the address to open in a map application
            val addressUri = Uri.parse("geo:0,0?q=Shop no. 8 upper ground floor, center square mall, Gumanpura, Kota, Rajasthan")
            val mapIntent = Intent(Intent.ACTION_VIEW, addressUri)
            // Make sure the user has a map app
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            }
        }

        // Set a click listener for the phone number
        phoneTextView.setOnClickListener {
            // Create a Uri for the phone number to open in the dialer
            val phoneUri = Uri.parse("tel:+919461903100")
            val dialIntent = Intent(Intent.ACTION_DIAL, phoneUri)
            startActivity(dialIntent)
        }
    }

    // Handles back button press in toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
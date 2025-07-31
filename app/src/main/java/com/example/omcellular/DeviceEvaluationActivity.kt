package com.example.omcellular5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DeviceEvaluationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_evaluation)

        val modelName = intent.getStringExtra("MODEL_NAME") ?: "Your Device"
        val toolbar: Toolbar = findViewById(R.id.toolbar_evaluation)
        setSupportActionBar(toolbar)
        supportActionBar?.title = modelName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val calculateButton: Button = findViewById(R.id.btn_calculate_price)
        val powerGroup: RadioGroup = findViewById(R.id.rg_power)
        val scratchesGroup: RadioGroup = findViewById(R.id.rg_scratches)

        calculateButton.setOnClickListener {
            var basePrice = 20000 // Start with a base price

            val powerSelection = powerGroup.checkedRadioButtonId
            if (powerSelection == R.id.rb_power_no) {
                basePrice = 500 // If it doesn't turn on, price is very low
            }

            val scratchesSelection = scratchesGroup.checkedRadioButtonId
            if (scratchesSelection == R.id.rb_scratches_yes) {
                basePrice -= 3000 // Deduct for scratches
            }

            val intent = Intent(this, QuoteActivity::class.java).apply {
                putExtra("FINAL_PRICE", basePrice)
            }
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
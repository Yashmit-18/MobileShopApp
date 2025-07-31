package com.example.omcellular5 // Make sure this matches your package name

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RepairActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repair)

        val toolbar: Toolbar = findViewById(R.id.toolbar_repair)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView: RecyclerView = findViewById(R.id.repair_recycler_view)
        // Use a grid with 2 columns
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // Create a list of RepairItem objects, including icons
        val repairIssues = listOf(
            RepairItem("Screen Damage", R.drawable.ic_screen),
            RepairItem("Battery Issues", R.drawable.ic_battery),
            RepairItem("Water Damage", R.drawable.ic_water_drop),
            RepairItem("Camera Repair", R.drawable.ic_camera),
            RepairItem("Charging Port", R.drawable.ic_repair), // Reusing repair icon
            RepairItem("Speaker/Mic", R.drawable.ic_contact) // Reusing contact icon
        )
        val adapter = RepairAdapter(repairIssues)
        recyclerView.adapter = adapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
package com.example.vechilelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_looking_for.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looking_for)

        tvManageBike.setOnClickListener {
            startActivity(Intent(this,VehicleListActivity::class.java))
        }

    }
}
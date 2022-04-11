package com.example.vechilelayout.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.example.vechilelayout.R
import kotlinx.android.synthetic.main.activity_looking_for.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looking_for)

        tvManageBike.setOnClickListener {
            startActivity(Intent(this, VehicleListActivity::class.java))
        }

    }
}
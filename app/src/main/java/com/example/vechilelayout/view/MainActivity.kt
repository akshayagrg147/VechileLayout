package com.example.vechilelayout.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vechilelayout.R
import kotlinx.android.synthetic.main.activity_looking_for.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looking_for)

        tvApplyForLoan.setOnClickListener {
            startActivity(Intent(this, ApplyLoanActivity::class.java))
        }

        tvManageBike.setOnClickListener {
            startActivity(Intent(this, VehicleListActivity::class.java))
        }

    }
}
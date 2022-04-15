package com.example.vechilelayout.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.vechilelayout.R
import kotlinx.android.synthetic.main.activity_apply_loan.*

class ApplyLoanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_loan)

        tvGetLoanOffer.setOnClickListener {
            startActivity(Intent(this, LoanTenureActivity::class.java))
        }
    }
}
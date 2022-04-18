package com.example.vechilelayout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.vechilelayout.R
import kotlinx.android.synthetic.main.activity_gas_electricitty_bill.*
import kotlinx.android.synthetic.main.skip_next.*

class GasElectricittyBill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gas_electricitty_bill)
        upload_button.setOnClickListener{
            upload_button.visibility=View.GONE
            after_upload.visibility=View.VISIBLE
            before_upload.visibility=View.GONE
            tvNext.alpha = 1F
        }
    }
}
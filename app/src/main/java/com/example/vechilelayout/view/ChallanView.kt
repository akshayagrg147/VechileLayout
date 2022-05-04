package com.example.vechilelayout.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vechilelayout.R
import kotlinx.android.synthetic.main.activity_challan_view.*

class ChallanView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challan_view)
        challan_details.setOnClickListener{
            val intent = Intent(this, ChallanListView::class.java)
            startActivity(intent)
        }
    }
}
package com.example.vechilelayout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.OwnerAdapter
import com.example.vechilelayout.adapter.customAdapterImageText
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.activity_income_proof.*
import kotlinx.android.synthetic.main.per_contact_details.*

class IncomeProof : AppCompatActivity() {
    lateinit var adapter : customAdapterImageText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_proof)
        callingOnership();
        upload_button.setOnClickListener{
            after_upload.visibility=View.VISIBLE
            before_upload.visibility=View.GONE
            after_upload_bottom.visibility=View.GONE
            upload_button.visibility=View.GONE

        }

    }
    private fun callingOnership() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        var ownerCategory = ArrayList<OwnerShipModals>()
        ownerCategory.add(OwnerShipModals("Select",R.drawable.ic_calendar_icon))
        ownerCategory.add(OwnerShipModals("Rented Alone",R.drawable.ic_calendar_icon))
        ownerCategory.add(OwnerShipModals("Rented with Friends ",R.drawable.ic_calendar_icon))
        ownerCategory.add(OwnerShipModals("Owned by Self/Spouse",R.drawable.ic_calendar_icon))
        ownerCategory.add(OwnerShipModals("Owned by Parents",R.drawable.ic_calendar_icon))
        ownerCategory.add(OwnerShipModals("Owned by Siblings",R.drawable.ic_calendar_icon))

        adapter = customAdapterImageText(this,ownerCategory)

        spinner.adapter = adapter
    }
}
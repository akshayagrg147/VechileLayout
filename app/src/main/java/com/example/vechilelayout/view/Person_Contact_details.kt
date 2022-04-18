package com.example.vechilelayout.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.OwnerAdapter
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.OwnerShipModals
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_vehicle_list.*
import kotlinx.android.synthetic.main.occup_income_details.*
import kotlinx.android.synthetic.main.per_contact_details.*

class Person_Contact_details : AppCompatActivity() {
    lateinit var adapter : OwnerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.per_contact_details)
       callingOnership()

        val jobcategory = resources.getStringArray(R.array.JobCategory)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_list, jobcategory
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@Person_Contact_details,
                        "" + jobcategory[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        tvSubmitNext.setOnClickListener {
            startActivity(Intent(this,occup_income_tax::class.java))
        }
    }

    private fun callingOnership() {
        var ownerCategory = ArrayList<OwnerShipModals>()
        ownerCategory.add(OwnerShipModals("Rented With Family",R.drawable.rented_family))
        ownerCategory.add(OwnerShipModals("Rented Alone",R.drawable.ic_rented_alone))
        ownerCategory.add(OwnerShipModals("Rented with Friends ",R.drawable.ic_rented_friends))
        ownerCategory.add(OwnerShipModals("Owned by Self/Spouse",R.drawable.ic_owned_by_self))
        ownerCategory.add(OwnerShipModals("Owned by Parents",R.drawable.ic_owned_by_parents))
        ownerCategory.add(OwnerShipModals("Owned by Siblings",R.drawable.ic_owned_by_sibling))

        adapter = OwnerAdapter(this,ownerCategory)
        rvOwnerShip.layoutManager = GridLayoutManager(this,3)
        rvOwnerShip.adapter = adapter
    }
}

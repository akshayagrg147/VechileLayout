package com.example.vechilelayout.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.ChallanListAdapter
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_apply_loan.*
import kotlinx.android.synthetic.main.activity_challanlist_view.*

class ChallanListView : AppCompatActivity() {
    lateinit var adapter : ChallanListAdapter
    var vehicleList = ArrayList<VehicleListModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challanlist_view)
        vehicleList.add(VehicleListModel("Honda Shine Drum"))
        vehicleList.add(VehicleListModel("Royal Enfield"))
        vehicleList.add(VehicleListModel("Bajaj Platinum"))
        vehicleList.add(VehicleListModel("Honda Pulsar"))
        vehicleList.add(VehicleListModel("Suzuki Discover"))
        vehicleList.add(VehicleListModel("Hero Honda Bike"))

        adapter = ChallanListAdapter(this,vehicleList,false)
        challan_list.layoutManager = LinearLayoutManager(this)
        challan_list.adapter = adapter


        challan_details.setOnClickListener{
            challan_details.visibility=View.GONE
            pay_chalan.visibility=View.VISIBLE
            spinner.visibility=View.GONE
            search_icon.visibility=View.GONE
            horizental_line.visibility=View.GONE
            challan_no_title.visibility=View.GONE

            vehicleList.clear()
            vehicleList.add(VehicleListModel("Honda Shine Drum"))
            vehicleList.add(VehicleListModel("Royal Enfield"))
            vehicleList.add(VehicleListModel("Bajaj Platinum"))
            vehicleList.add(VehicleListModel("Honda Pulsar"))
            vehicleList.add(VehicleListModel("Suzuki Discover"))
            vehicleList.add(VehicleListModel("Hero Honda Bike"))

            adapter = ChallanListAdapter(this,vehicleList,true)
            challan_list.layoutManager = LinearLayoutManager(this)
            challan_list.adapter = adapter

        }
        pay_chalan.setOnClickListener{
            val intent = Intent(this, layout_vechile_Detail::class.java)
            startActivity(intent)
        }
    }
}
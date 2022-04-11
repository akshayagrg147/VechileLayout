package com.example.vechilelayout.view

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_vehicle_list.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*


class VehicleListActivity : AppCompatActivity() {

    lateinit var adapter : VehicleListAdapter
    var vehicleList = ArrayList<VehicleListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)

        vehicleList.add(VehicleListModel("Honda Shine Drum"))
        vehicleList.add(VehicleListModel("Royal Enfield"))
        vehicleList.add(VehicleListModel("Bajaj Platinum"))
        vehicleList.add(VehicleListModel("Honda Pulsar"))
        vehicleList.add(VehicleListModel("Suzuki Discover"))
        vehicleList.add(VehicleListModel("Hero Honda Bike"))

        adapter = VehicleListAdapter(this,vehicleList)
        rvVehicle.layoutManager = GridLayoutManager(this,2)
        rvVehicle.adapter = adapter

        llFilter.setOnClickListener {
            val dialog = Dialog(this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen)
            dialog.setContentView(R.layout.filter_screen)
            dialog.location_icon.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}
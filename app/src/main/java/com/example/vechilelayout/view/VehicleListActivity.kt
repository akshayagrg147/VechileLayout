package com.example.vechilelayout.view

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.FilterCategoryTypedapter
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_vehicle_list.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.filter_screen.*


class VehicleListActivity : AppCompatActivity() {

    lateinit var adapter : VehicleListAdapter
    lateinit var adapter1 : FilterCategoryTypedapter

    var vehicleList = ArrayList<VehicleListModel>()
    var categoryType = ArrayList<VehicleListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)

        vehicleList.add(VehicleListModel("Honda Shine Drum"))
        vehicleList.add(VehicleListModel("Royal Enfield"))
        vehicleList.add(VehicleListModel("Bajaj Platinum"))
        vehicleList.add(VehicleListModel("Honda Pulsar"))
        vehicleList.add(VehicleListModel("Suzuki Discover"))
        vehicleList.add(VehicleListModel("Hero Honda Bike"))

        categoryType.add(VehicleListModel("Moped"))
        categoryType.add(VehicleListModel("Bike"))
        categoryType.add(VehicleListModel("Scooty"))
        categoryType.add(VehicleListModel("Electric"))

        adapter = VehicleListAdapter(this,vehicleList)
        rvVehicle.layoutManager = GridLayoutManager(this,2)
        rvVehicle.adapter = adapter

        llFilter.setOnClickListener {
            val dialog = Dialog(this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen)
            dialog.setContentView(R.layout.filter_screen)
            dialog.location_icon.setOnClickListener {
                dialog.dismiss()
            }

            adapter1 = FilterCategoryTypedapter(this,categoryType)
            dialog.rvType.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            dialog.rvType.adapter = adapter1

            dialog.show()
        }
    }
}
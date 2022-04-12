package com.example.vechilelayout.view

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.FilterCategoryBranddapter
import com.example.vechilelayout.adapter.FilterCategoryTypedapter
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_vehicle_list.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.filter_screen.*


class VehicleListActivity : AppCompatActivity() {

    lateinit var adapter : VehicleListAdapter
    lateinit var adapter1 : FilterCategoryTypedapter
    lateinit var brandAdapter: FilterCategoryBranddapter

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

        adapter = VehicleListAdapter(this,vehicleList)
        rvVehicle.layoutManager = GridLayoutManager(this,2)
        rvVehicle.adapter = adapter

        llFilter.setOnClickListener {
            val dialog = Dialog(this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen)
            dialog.setContentView(R.layout.filter_screen)
            dialog.location_icon.setOnClickListener {
                dialog.dismiss()
            }

            dialog.rvType.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            categoryType.clear()
            categoryType.add(VehicleListModel("Moped"))
            categoryType.add(VehicleListModel("Bike"))
            categoryType.add(VehicleListModel("Scooty"))
            categoryType.add(VehicleListModel("Electric"))
            adapter1 = FilterCategoryTypedapter(this,categoryType)
            dialog.rvType.adapter = adapter1

            dialog.llType.setOnClickListener {
                dialog.rvType.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
                categoryType.clear()
                categoryType.add(VehicleListModel("Moped"))
                categoryType.add(VehicleListModel("Bike"))
                categoryType.add(VehicleListModel("Scooty"))
                categoryType.add(VehicleListModel("Electric"))
                adapter1 = FilterCategoryTypedapter(this,categoryType)
                dialog.rvType.adapter = adapter1
            }
            dialog.llBrand.setOnClickListener {
                dialog.rvType.layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
                categoryType.clear()
                categoryType.add(VehicleListModel("Hero"))
                categoryType.add(VehicleListModel("Suzuki"))
                categoryType.add(VehicleListModel("Bajaj"))
                categoryType.add(VehicleListModel("KTM"))
                categoryType.add(VehicleListModel("Royal Enfield"))
                categoryType.add(VehicleListModel("Yamaha"))
                categoryType.add(VehicleListModel("TVS Electric"))
                brandAdapter = FilterCategoryBranddapter(this,categoryType)
                dialog.rvType.adapter = brandAdapter
            }
            dialog.llBudget.setOnClickListener {
                dialog.rvType.layoutManager = GridLayoutManager(this,2, RecyclerView.VERTICAL,false)
                categoryType.clear()
                categoryType.add(VehicleListModel(">60k"))
                categoryType.add(VehicleListModel("60k - 80k"))
                categoryType.add(VehicleListModel("80k - 1L"))
                categoryType.add(VehicleListModel("1L - 2L"))
                categoryType.add(VehicleListModel("1.2L - 1.5L"))
                categoryType.add(VehicleListModel("1.5L - 1.7L"))
                categoryType.add(VehicleListModel("1.7L - 2L"))
                brandAdapter = FilterCategoryBranddapter(this,categoryType)
                dialog.rvType.adapter = brandAdapter
            }
            dialog.llMileage.setOnClickListener {
                dialog.rvType.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
                categoryType.clear()
                categoryType.add(VehicleListModel("Below 40 Kmpl"))
                categoryType.add(VehicleListModel("40 - 60 Kmpl"))
                categoryType.add(VehicleListModel("60 - 80 Kmpl"))
                categoryType.add(VehicleListModel("Above 80 Kmpl"))
                brandAdapter = FilterCategoryBranddapter(this,categoryType)
                dialog.rvType.adapter = brandAdapter
            }
            dialog.show()
        }
    }
}
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
import com.example.vechilelayout.adapter.SpecificationAdapter
import com.example.vechilelayout.adapter.VehicleListAdapter
import com.example.vechilelayout.model.VehicleListModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_challanlist_view.*
import kotlinx.android.synthetic.main.activity_vehicle_list.*
import kotlinx.android.synthetic.main.bottom_sheet_sortby.view.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.filter_screen.*

class VehicleListActivity : AppCompatActivity() {

    lateinit var adapter : VehicleListAdapter
    lateinit var adapter1 : FilterCategoryTypedapter
    lateinit var brandAdapter: FilterCategoryBranddapter
    lateinit var sheetBehavior: BottomSheetBehavior<*>
    lateinit var specificationAdapter: SpecificationAdapter

    var vehicleList = ArrayList<VehicleListModel>()
    var filterCtegoryList = ArrayList<VehicleListModel>()
    var categoryType = ArrayList<VehicleListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_vechile_detail)


//        vehicleList.add(VehicleListModel("Honda Shine Drum"))
//        vehicleList.add(VehicleListModel("Royal Enfield"))
//        vehicleList.add(VehicleListModel("Bajaj Platinum"))
//        vehicleList.add(VehicleListModel("Honda Pulsar"))
//        vehicleList.add(VehicleListModel("Suzuki Discover"))
//        vehicleList.add(VehicleListModel("Hero Honda Bike"))
//
//        adapter = VehicleListAdapter(this,vehicleList)
//        challan_list.layoutManager = LinearLayoutManager(this)
//        challan_list.adapter = adapter


    }
}
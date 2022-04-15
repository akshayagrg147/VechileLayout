package com.example.vechilelayout.view

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.*
import com.example.vechilelayout.model.VehicleListModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_bike_details.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.dialog_specification.*
import kotlinx.android.synthetic.main.price_break_up.view.*


class LoanTenureActivity : AppCompatActivity() {

    lateinit var adapter2 : BikeLoanTenureAdapter
    lateinit var vehicleVariantAdapter: BikeLoanVariantAdapter

    var vehicleVariantList = ArrayList<VehicleListModel>()
    var tenureList = ArrayList<VehicleListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_loan_tenure)

        vehicleVariantList.add(VehicleListModel("Fireball"))
        vehicleVariantList.add(VehicleListModel("Stellar"))
        vehicleVariantList.add(VehicleListModel("Supernova"))
        vehicleVariantList.add(VehicleListModel("Fireball"))
        vehicleVariantList.add(VehicleListModel("Supernova"))

        tenureList.add(VehicleListModel("1 Year"))
        tenureList.add(VehicleListModel("1+1 Yrs"))
        tenureList.add(VehicleListModel("2+1 Yrs"))
        tenureList.add(VehicleListModel("3+1 Yrs"))

        adapter2 = BikeLoanTenureAdapter(this,tenureList)
        rvColor.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        rvColor.adapter = adapter2

        vehicleVariantAdapter = BikeLoanVariantAdapter(this,vehicleVariantList)
        rvVariant.adapter = vehicleVariantAdapter

        tvColor.setOnClickListener {
            rvColor.visibility = View.VISIBLE
            rvVariant.visibility = View.GONE
            tvColor.setTextColor(ContextCompat.getColor(this,R.color.white))
            tvColor.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.green_400))
            tvVariant.setTextColor(ContextCompat.getColor(this,R.color.grey_login_new))
            tvVariant.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.bg_variant))
        }

        tvVariant.setOnClickListener {
            rvColor.visibility = View.GONE
            rvVariant.visibility = View.VISIBLE
            tvVariant.setTextColor(ContextCompat.getColor(this,R.color.white))
            tvVariant.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.green_400))
            tvColor.setTextColor(ContextCompat.getColor(this,R.color.grey_login_new))
            tvColor.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.bg_variant))
        }

    }
}
package com.example.vechilelayout.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.ApplyLoanTenureAdapter
import com.example.vechilelayout.adapter.BikeLoanTenureAdapter
import com.example.vechilelayout.adapter.SpecificationAdapter
import com.example.vechilelayout.adapter.SpecificationCategoryAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_apply_loan.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.dialog_search_bike.*
import kotlinx.android.synthetic.main.dialog_specification.*

class ApplyLoanActivity : AppCompatActivity() {

    lateinit var adapter2 : ApplyLoanTenureAdapter
    var tenureList = ArrayList<VehicleListModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_loan)

        tenureList.add(VehicleListModel("1 Year"))
        tenureList.add(VehicleListModel("1+1 Yrs"))
        tenureList.add(VehicleListModel("2+1 Yrs"))
        tenureList.add(VehicleListModel("3+1 Yrs"))

        adapter2 = ApplyLoanTenureAdapter(this,tenureList)
        rvLoanTenure.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        rvLoanTenure.adapter = adapter2

        tvGetLoanOffer.setOnClickListener {
            startActivity(Intent(this, LoanTenureActivity::class.java))
        }

        tvSearch.setOnClickListener {
            val dialog = Dialog(this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen)
            dialog.setContentView(R.layout.dialog_search_bike)
            dialog.toolBarTitle.text = "SEARCH YOUR BIKE"

            dialog.show()
            dialog.toolBarIcon.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}
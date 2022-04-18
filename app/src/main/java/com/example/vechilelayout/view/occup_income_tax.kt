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
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.occup_income_details.*

class occup_income_tax : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.occup_income_details)
        callingSalary()
        callingCibil()
        val languages = resources.getStringArray(R.array.JobCategory)
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                R.layout.spinner_list, languages
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@occup_income_tax,
                        "" + languages[position], Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        tvCheckEligibilty.setOnClickListener {
            startActivity(Intent(this,DocumentPanCardUploadActivity::class.java))
        }

    }

    private fun callingSalary() {
        lateinit var adapter: OwnerAdapter

        var salary = ArrayList<OwnerShipModals>()
        salary.add(OwnerShipModals("Cash", R.drawable.ic_cash))
        salary.add(OwnerShipModals("Credit to Bank", R.drawable.ic_credit_to_bank))
        salary.add(OwnerShipModals("Cheque", R.drawable.ic_cheque))


        adapter = OwnerAdapter(this, salary)
        salaryrv.layoutManager = GridLayoutManager(this, 3)
        salaryrv.adapter = adapter

    }

    private fun callingCibil() {
        lateinit var adapter: OwnerAdapter

        var salary = ArrayList<OwnerShipModals>()
        salary.add(OwnerShipModals("Less than 650", R.drawable.ic_less_650))
        salary.add(OwnerShipModals("More than 650", R.drawable.ic_more_650))
        salary.add(OwnerShipModals("I don't know", R.drawable.ic_dont_know))

        adapter = OwnerAdapter(this, salary)
        cibilrv.layoutManager = GridLayoutManager(this, 3)
        cibilrv.adapter = adapter

    }
}
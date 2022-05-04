package com.example.vechilelayout.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.DocumentListAdapter
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.layout_all_documesnts.*


class AlldocumentsLayout : AppCompatActivity() {
    lateinit var adapter : DocumentListAdapter
    var vehicleList = ArrayList<VehicleListModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_all_documesnts)
        linearLayout.visibility=View.VISIBLE
        linearLayout1.visibility=View.VISIBLE

        vehicleList.add(VehicleListModel("Honda Shine Drum"))
        vehicleList.add(VehicleListModel("Royal Enfield"))
        vehicleList.add(VehicleListModel("Bajaj Platinum"))
        adapter = DocumentListAdapter(this,vehicleList,false)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = adapter

        first_owner.setOnClickListener{
            linearLayout.visibility=View.GONE
            linearLayout1.visibility=View.GONE
            linearLayout_doc.visibility=View.VISIBLE
            vechile_doc.visibility=View.VISIBLE

        }
        documents_Button.setOnClickListener{
            vechile_doc.visibility=View.GONE
            list.visibility=View.GONE
            upload_certificate.visibility=View.VISIBLE


        }
        tvUpload.setOnClickListener{
            upload_certificate.visibility=View.GONE
            vechile_doc.visibility=View.VISIBLE
            option_menu_layout.visibility=View.VISIBLE
            list.visibility=View.VISIBLE
            vehicleList.clear()

            vehicleList.add(VehicleListModel("Honda Shine Drum"))
            vehicleList.add(VehicleListModel("Royal Enfield"))
            vehicleList.add(VehicleListModel("Bajaj Platinum"))
            adapter = DocumentListAdapter(this,vehicleList,true)
            list.layoutManager = LinearLayoutManager(this)
            list.adapter = adapter

        }
        option_menu.setOnClickListener{
            val popupMenu =  PopupMenu(this, it);

            // Inflating popup menu from popup_menu.xml file
            popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu);

            // Showing the popup menu
            popupMenu.show();
        }
        option_menu_layout.setOnClickListener{
            val intent = Intent(this, ChallanView::class.java)
            startActivity(intent)

        }



    }

}
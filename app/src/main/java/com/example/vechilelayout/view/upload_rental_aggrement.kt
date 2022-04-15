package com.example.vechilelayout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.DocumentsAdapter
import com.example.vechilelayout.adapter.OwnerAdapter
import com.example.vechilelayout.model.DocumentsModals
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.activity_upload_rental_aggrement.*
import kotlinx.android.synthetic.main.per_contact_details.*

class upload_rental_aggrement : AppCompatActivity() {
    lateinit var adapter : DocumentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_rental_aggrement)
        upload_button.setOnClickListener{
            upload_button.visibility=View.GONE
            after_upload.visibility=View.VISIBLE
            before_upload.visibility=View.GONE

        }
        callingDocumentsData()
    }
    private fun callingDocumentsData() {
        var documentsCategory = ArrayList<DocumentsModals>()
        documentsCategory.add(DocumentsModals(R.drawable.rented_family))
        adapter = DocumentsAdapter(this,documentsCategory)
        rv_documents.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        rv_documents.adapter = adapter
    }
}
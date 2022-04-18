package com.example.vechilelayout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.DocumentsAdapter
import com.example.vechilelayout.adapter.customAdapterImageText
import com.example.vechilelayout.model.DocumentsModals
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.activity_buisness_proof.*
import kotlinx.android.synthetic.main.activity_buisness_proof.after_upload
import kotlinx.android.synthetic.main.activity_buisness_proof.before_upload
import kotlinx.android.synthetic.main.activity_buisness_proof.rv_documents
import kotlinx.android.synthetic.main.activity_buisness_proof.upload_button
import kotlinx.android.synthetic.main.activity_upload_rental_aggrement.*

class buisness_proof : AppCompatActivity() {
    lateinit var adapter : DocumentsAdapter
    lateinit var adapter1 : customAdapterImageText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buisness_proof)
        upload_button.setOnClickListener{
            upload_button.visibility=View.GONE
            before_upload.visibility=View.GONE
            after_upload.visibility=View.VISIBLE
            callingDocumentsData()
        }
        callingBuisnessProof()

    }
    private fun callingDocumentsData() {
        var documentsCategory = ArrayList<DocumentsModals>()
        documentsCategory.add(DocumentsModals(R.drawable.rented_family))

        adapter = DocumentsAdapter(this,documentsCategory)
        rv_documents.layoutManager = GridLayoutManager(this,  2)
        rv_documents.adapter = adapter
    }
    private fun callingBuisnessProof() {
        val spinner = findViewById<Spinner>(R.id.spinner)
        var buisnessproof = ArrayList<OwnerShipModals>()
        buisnessproof.add(OwnerShipModals("Select",R.drawable.ic_calendar_icon))
        buisnessproof.add(OwnerShipModals("Bank Loan",R.drawable.ic_calendar_icon))


        adapter1 = customAdapterImageText(this,buisnessproof)

        spinner.adapter = adapter1
    }
}
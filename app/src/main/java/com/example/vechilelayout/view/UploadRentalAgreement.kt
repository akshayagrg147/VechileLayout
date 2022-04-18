package com.example.vechilelayout.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.DocumentsAdapter
import com.example.vechilelayout.model.DocumentsModals
import kotlinx.android.synthetic.main.activity_upload_rental_aggrement.*
import kotlinx.android.synthetic.main.per_contact_details.*
import kotlinx.android.synthetic.main.skip_next.*

class UploadRentalAgreement : AppCompatActivity() {
    lateinit var adapter : DocumentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_rental_aggrement)
        upload_button.setOnClickListener{
            upload_button.visibility=View.GONE
            after_upload.visibility=View.VISIBLE
            before_upload.visibility=View.GONE
            tvNext.alpha = 1F

        }
        callingDocumentsData()
    }
    private fun callingDocumentsData() {
        var documentsCategory = ArrayList<DocumentsModals>()
        documentsCategory.add(DocumentsModals(R.drawable.rented_family))
        documentsCategory.add(DocumentsModals(R.drawable.rented_family))

        adapter = DocumentsAdapter(this,documentsCategory)
        rv_documents.layoutManager = GridLayoutManager(this,  2)
        rv_documents.adapter = adapter
    }
}
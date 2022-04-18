package com.example.vechilelayout.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.DocumentsAdapter
import com.example.vechilelayout.model.DocumentsModals
import kotlinx.android.synthetic.main.activity_buisness_proof.*
import kotlinx.android.synthetic.main.activity_buisness_proof.after_upload
import kotlinx.android.synthetic.main.activity_buisness_proof.before_upload
import kotlinx.android.synthetic.main.activity_buisness_proof.rv_documents
import kotlinx.android.synthetic.main.activity_buisness_proof.upload_button
import kotlinx.android.synthetic.main.activity_upload_rental_aggrement.*

class buisness_proof : AppCompatActivity() {
    lateinit var adapter : DocumentsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buisness_proof)
        upload_button.setOnClickListener{
            upload_button.visibility=View.GONE
            before_upload.visibility=View.GONE
            after_upload.visibility=View.VISIBLE
            callingDocumentsData()
        }

    }
    private fun callingDocumentsData() {
        var documentsCategory = ArrayList<DocumentsModals>()
        documentsCategory.add(DocumentsModals(R.drawable.rented_family))

        adapter = DocumentsAdapter(this,documentsCategory)
        rv_documents.layoutManager = GridLayoutManager(this,  2)
        rv_documents.adapter = adapter
    }
}
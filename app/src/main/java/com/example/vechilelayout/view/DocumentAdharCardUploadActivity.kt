package com.example.vechilelayout.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.vechilelayout.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_document_adhar_upload.*
import kotlinx.android.synthetic.main.bottom_sheet_file_upload.view.*
import kotlinx.android.synthetic.main.skip_next.*
import kotlinx.android.synthetic.main.toolbar_support.*

class DocumentAdharCardUploadActivity : AppCompatActivity() {

    lateinit var sheetBehavior: BottomSheetBehavior<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_adhar_upload)

        sheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bsFileUpload))
        tvDocumentName.text = "Adhar Card"
        tvDocSide.text = "Front Side"

        tvUpload.setOnClickListener {
           sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            tvNext.isEnabled = true
            tvNext.alpha = 1F
        }

        bsFileUpload.ivClose.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
         tvNext.setOnClickListener {
             llUploadDocSuccess.visibility = View.VISIBLE
             ivDelete.visibility = View.VISIBLE
             llUploadDoc.visibility = View.GONE
             tvLabel.visibility = View.GONE
             tvUpload.visibility = View.GONE
         }

        tvSkip.setOnClickListener {
            startActivity(Intent(this,GasElectricittyBill::class.java))
        }

        ivBack.setOnClickListener {
            finish()
        }
    }
}
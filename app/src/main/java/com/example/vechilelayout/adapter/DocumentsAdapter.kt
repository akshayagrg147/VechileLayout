package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.DocumentsModals
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.category_menu_item.view.*
import kotlinx.android.synthetic.main.document_layout.view.*
import kotlinx.android.synthetic.main.owner_item.view.*

class DocumentsAdapter(var context: Context, var list : ArrayList<DocumentsModals>) :
    RecyclerView.Adapter<DocumentsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.document_layout, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position],position)


    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(documentsModals: DocumentsModals, position: Int){
            itemView.imageView.setImageDrawable(ContextCompat.getDrawable(context,documentsModals.image))
        }


    }

}
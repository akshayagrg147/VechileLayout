package com.example.vechilelayout.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import com.example.vechilelayout.view.BikeDetailsActivity
import kotlinx.android.synthetic.main.documenst_list.view.*
import kotlinx.android.synthetic.main.product_item.view.*

class DocumentListAdapter(var context: Context, var list : ArrayList<VehicleListModel>,val upload:Boolean) :
    RecyclerView.Adapter<DocumentListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.documenst_list, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position])
//        holder.itemView.setOnClickListener {
//            context.startActivity(Intent(context,BikeDetailsActivity::class.java))
//        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(vehicleListModel: VehicleListModel){
            if(upload)
                itemView.upload_button.visibility=View.VISIBLE

            //itemView.vehicleName.setText(vehicleListModel.bikeName)
        }
    }

}
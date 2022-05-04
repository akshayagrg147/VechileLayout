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
import kotlinx.android.synthetic.main.product_item.view.*

class ChallanListAdapter(var context: Context, var list : ArrayList<VehicleListModel>,var bool:Boolean) :
    RecyclerView.Adapter<ChallanListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view: View?=null
        val inflater: LayoutInflater = LayoutInflater.from(context)
        view = if(bool)
            inflater.inflate(R.layout.challan_layout_item, parent,false)
        else
            inflater.inflate(R.layout.recent_searches, parent,false)
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
            //itemView.vehicleName.setText(vehicleListModel.bikeName)
        }
    }

}
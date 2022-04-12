package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.category_brand_subitem.view.*
import kotlinx.android.synthetic.main.category_type_subitem.view.*
import kotlinx.android.synthetic.main.product_item.view.*
import kotlinx.android.synthetic.main.specification_type_subitem.view.*

class SpecificationCategoryAdapter(var context: Context, var list : ArrayList<VehicleListModel>) :
    RecyclerView.Adapter<SpecificationCategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.specification_type_subitem, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(vehicleListModel: VehicleListModel){
            itemView.tvTitle.setText(vehicleListModel.bikeName)
        }
    }

}
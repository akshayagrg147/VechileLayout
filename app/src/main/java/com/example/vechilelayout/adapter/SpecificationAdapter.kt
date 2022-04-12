package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.category_brand_subitem.view.*
import kotlinx.android.synthetic.main.category_menu_item.view.*
import kotlinx.android.synthetic.main.category_type_subitem.view.*
import kotlinx.android.synthetic.main.product_item.view.*

class SpecificationAdapter(var context: Context, var list : ArrayList<VehicleListModel>, var clickListener:(Int) -> Unit) :
    RecyclerView.Adapter<SpecificationAdapter.MyViewHolder>() {

    var tempPosition = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.category_menu_item, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onItemClick(position,clickListener)
        holder.onbind(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onbind(vehicleListModel: VehicleListModel, position: Int){
            itemView.tvTitle.setText(vehicleListModel.bikeName)
            itemView.ivIcon.setImageDrawable(ContextCompat.getDrawable(context,vehicleListModel.image))
            if(tempPosition == position){
                itemView.llParent.setBackgroundResource(R.drawable.bg_border_green)
            } else {
                itemView.llParent.setBackgroundResource(R.drawable.bg_border)
            }
        }

        fun onItemClick(position: Int,  clickListener: (Int) -> Unit){
            itemView.setOnClickListener {
                tempPosition = position
                notifyDataSetChanged()
                clickListener(position)
            }
        }
    }

}
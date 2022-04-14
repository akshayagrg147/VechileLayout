package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.OwnerShipModals
import kotlinx.android.synthetic.main.category_menu_item.view.*
import kotlinx.android.synthetic.main.owner_item.view.*

class OwnerAdapter(var context: Context, var list : ArrayList<OwnerShipModals>) :
    RecyclerView.Adapter<OwnerAdapter.MyViewHolder>() {
    var tempPosition : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.owner_item, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position],position)
        holder.onItemClick(position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(vehicleListModel: OwnerShipModals, position: Int){
            itemView.ownership.text = vehicleListModel.name
            itemView.imageowner.setImageDrawable(ContextCompat.getDrawable(context,vehicleListModel.image))
            if(position == tempPosition){
                itemView.llParentOwner.setBackgroundResource(R.drawable.bg_border_green)
            }
            else
            {
                itemView.llParentOwner.setBackgroundResource(0)
            }

        }

        fun onItemClick(position: Int) {
            itemView.setOnClickListener {
                tempPosition = position
                notifyDataSetChanged()
            }

        }
    }

}
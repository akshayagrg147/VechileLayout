package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.item_loan_tenure_card.view.*

class BikeLoanTenureAdapter(var context: Context, var list: ArrayList<VehicleListModel>) :
    RecyclerView.Adapter<BikeLoanTenureAdapter.MyViewHolder>() {

    var tempPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_loan_tenure_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onItemClick(position)
        holder.onbind(list[position], position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(vehicleListModel: VehicleListModel, position: Int) {
            itemView.tvBikeVariant.setText(vehicleListModel.bikeName)
            if (position == tempPosition) {
                itemView.tvBikeVariant.setTextColor(ContextCompat.getColor(context, R.color.green_400))
                itemView.tvBikeVariant.setBackgroundResource(R.drawable.bg_variant_select)
            } else {
                itemView.tvBikeVariant.setTextColor(ContextCompat.getColor(context, R.color.reminder_category_text))
                itemView.tvBikeVariant.setBackgroundResource(0)
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
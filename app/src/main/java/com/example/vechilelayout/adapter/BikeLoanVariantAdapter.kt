package com.example.vechilelayout.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.item_bike_loan_variant.view.*

class BikeLoanVariantAdapter(var context: Context, var list: ArrayList<VehicleListModel>) :
    RecyclerView.Adapter<BikeLoanVariantAdapter.MyViewHolder>() {

    var tempPosition: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_bike_loan_variant, parent, false)
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

                itemView.tvBikeVariant.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.reminder_category_text))
                }
                itemView.tvBikePrice.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.reminder_category_text))
                    textSize = 13F
                    setBackgroundResource( R.drawable.bg_variant_select)
                }
            } else {
                itemView.tvBikeVariant.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.grey_login_new))
                }
                itemView.tvBikePrice.apply {
                    setTextColor(ContextCompat.getColor(context, R.color.grey_login_new))
                    textSize = 10F
                    setBackgroundResource( R.drawable.bg_variant_unselect)
                }
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
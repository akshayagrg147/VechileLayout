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
import kotlinx.android.synthetic.main.item_video_review.view.*
import kotlinx.android.synthetic.main.product_item.view.*

class VideoReviewAdapter(var context: Context, var list : ArrayList<VehicleListModel>) :
    RecyclerView.Adapter<VideoReviewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_video_review, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position])
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,BikeDetailsActivity::class.java))
        }
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
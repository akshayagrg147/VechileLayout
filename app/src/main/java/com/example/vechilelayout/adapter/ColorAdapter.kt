package com.example.vechilelayout.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import com.example.vechilelayout.view.BikeDetailsActivity
import kotlinx.android.synthetic.main.item_color.view.*
import kotlinx.android.synthetic.main.item_video_review.view.*
import kotlinx.android.synthetic.main.product_item.view.*

class ColorAdapter(var context: Context, var list : ArrayList<Drawable>) :
    RecyclerView.Adapter<ColorAdapter.MyViewHolder>() {

    var tempPosition : Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_color, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onItemClick(position)
        holder.onbind(list[position],position)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(drawable: Drawable,position: Int){
            itemView.ivColor.setImageDrawable(drawable)
            if(position == tempPosition){
                itemView.ivColorSelect.visibility = View.VISIBLE
            } else {
                itemView.ivColorSelect.visibility = View.INVISIBLE
            }
        }

        fun onItemClick(position: Int){
            itemView.setOnClickListener {
                tempPosition = position
                notifyDataSetChanged()
            }
        }
    }

}
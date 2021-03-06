package com.example.vechilelayout.adapter

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.model.VehicleListModel
import com.example.vechilelayout.view.BikeDetailsActivity
import kotlinx.android.synthetic.main.item_color.view.*
import kotlinx.android.synthetic.main.item_video_review.view.*
import kotlinx.android.synthetic.main.item_viewpager.view.*
import kotlinx.android.synthetic.main.product_item.view.*

class ViewPagerAdapter(var context: Context, var list : ArrayList<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.item_viewpager, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onbind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onbind(image: Int){
            itemView.ivSliderImage.setImageDrawable(ContextCompat.getDrawable(context,image))
        }
    }

}
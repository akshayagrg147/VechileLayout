package com.example.vechilelayout.view

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.*
import com.example.vechilelayout.model.VehicleListModel
import kotlinx.android.synthetic.main.activity_bike_details.*
import kotlinx.android.synthetic.main.activity_vehicle_list.*

class BikeDetailsActivity : AppCompatActivity() {

    lateinit var adapter : VideoReviewAdapter
    lateinit var adapter1 : SimilarBikeAdapter
    lateinit var adapter2 : ColorAdapter

    var videoReviewList = ArrayList<VehicleListModel>()
    var similarBikeList = ArrayList<VehicleListModel>()
    var colorList = ArrayList<Drawable>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bike_details)

        videoReviewList.add(VehicleListModel("Good Things"))
        videoReviewList.add(VehicleListModel("Outstanding"))
        videoReviewList.add(VehicleListModel("Good Things"))
        videoReviewList.add(VehicleListModel("Outstanding"))
        videoReviewList.add(VehicleListModel("Good Things"))
        videoReviewList.add(VehicleListModel("Outstanding"))
        videoReviewList.add(VehicleListModel("Good Things"))

        similarBikeList.add(VehicleListModel("Honda Shine Drum"))
        similarBikeList.add(VehicleListModel("Royal Enfield"))
        similarBikeList.add(VehicleListModel("Bajaj Platinum"))
        similarBikeList.add(VehicleListModel("Honda Pulsar"))
        similarBikeList.add(VehicleListModel("Suzuki Discover"))
        similarBikeList.add(VehicleListModel("Hero Honda Bike"))

        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)
        colorList.add(AppCompatResources.getDrawable(this,R.drawable.bg_circle_blue)!!)

        adapter = VideoReviewAdapter(this,videoReviewList)
        rvVideoReview.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rvVideoReview.adapter = adapter

        adapter1 = SimilarBikeAdapter(this,similarBikeList)
        rvSimilarBikes.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rvSimilarBikes.adapter = adapter1

        adapter2 = ColorAdapter(this,colorList)
        rvColor.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        rvColor.adapter = adapter2

    }
}
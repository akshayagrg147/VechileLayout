package com.example.vechilelayout.view

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.*
import com.example.vechilelayout.model.VehicleListModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bike_details.*
import kotlinx.android.synthetic.main.custom_toolbarfilter.*
import kotlinx.android.synthetic.main.dialog_specification.*
import kotlinx.android.synthetic.main.price_break_up.view.*


class BikeDetailsActivity : AppCompatActivity() {

    lateinit var adapter : VideoReviewAdapter
    lateinit var adapter1 : SimilarBikeAdapter
    lateinit var adapter2 : ColorAdapter
    lateinit var specificationAdapter: SpecificationAdapter
    lateinit var specificationCategoryAdapter: SpecificationCategoryAdapter
    lateinit var sheetBehavior: BottomSheetBehavior<*>
    lateinit var viewPagerAdapter: ViewPagerAdapter

    var videoReviewList = ArrayList<VehicleListModel>()
    var similarBikeList = ArrayList<VehicleListModel>()
    var colorList = ArrayList<Drawable>()
    var imageList = ArrayList<Int>()
    var categoryType = ArrayList<VehicleListModel>()
    var specificationType = ArrayList<VehicleListModel>()

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

        imageList.add(R.drawable.ic_display_bike)
        imageList.add(R.drawable.ic_display_bike)
        imageList.add(R.drawable.ic_display_bike)

        viewPagerAdapter = ViewPagerAdapter(this,imageList)
        viewPager.adapter = viewPagerAdapter

        sheetBehavior = BottomSheetBehavior.from(findViewById(R.id.bottomSheetTT))
        adapter = VideoReviewAdapter(this,videoReviewList)
        rvVideoReview.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rvVideoReview.adapter = adapter

        adapter1 = SimilarBikeAdapter(this,similarBikeList)
        rvSimilarBikes.layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        rvSimilarBikes.adapter = adapter1

        adapter2 = ColorAdapter(this,colorList)
        rvColor.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        rvColor.adapter = adapter2

        tvPriceBreakUp.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bottomSheetTT.ivClose.setOnClickListener {
            with(sheetBehavior) { setPeekHeight(0,false) }
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        fun specificationItemClick(position : Int, dialog: Dialog){
            categoryType.clear()
            when(position){
                1->{
                    categoryType.add(VehicleListModel("WHEELBASE"))
                    categoryType.add(VehicleListModel("GROUND CLEARANCE"))
                    categoryType.add(VehicleListModel("LENGTH"))
                    categoryType.add(VehicleListModel("WIDTH"))
                    categoryType.add(VehicleListModel("HEIGHT"))
                }
                2->{
                    categoryType.add(VehicleListModel("TYPE"))
                    categoryType.add(VehicleListModel("FRONT SUSPENSION"))
                    categoryType.add(VehicleListModel("REAR SUSPENSION"))
                }
                3->{
                    categoryType.add(VehicleListModel("ABS"))
                    categoryType.add(VehicleListModel("FRONT BRAKE TYPE"))
                    categoryType.add(VehicleListModel("REAR BRAKE TYPE"))
                    categoryType.add(VehicleListModel("REAR BRAKE SIZE"))
                    categoryType.add(VehicleListModel("CALLIPER TYPE"))
                }
                4->{
                    categoryType.add(VehicleListModel("HEADLIGHT"))
                    categoryType.add(VehicleListModel("BATTERY CAPACITY"))
                    categoryType.add(VehicleListModel("BATTERY TYPE"))
                }
                else -> {
                    categoryType.add(VehicleListModel("TYPE"))
                    categoryType.add(VehicleListModel("DISPLACEMENT"))
                    categoryType.add(VehicleListModel("COMPRESSION RATIO"))
                    categoryType.add(VehicleListModel("MAXIMUM TORQUE"))
                    categoryType.add(VehicleListModel("CLUTCH"))

                }
            }
            specificationCategoryAdapter = SpecificationCategoryAdapter(this,categoryType)
            dialog.rvSpecificationCategory.adapter = specificationCategoryAdapter
        }

        tvFullSpecification.setOnClickListener {
            val dialog = Dialog(this, R.style.Theme_AppCompat_Light_NoActionBar_FullScreen)
            dialog.setContentView(R.layout.dialog_specification)
            dialog.location.setText("SPECIFICATION")
            dialog.show()
            dialog.location_icon.setOnClickListener {
                dialog.dismiss()
            }
            dialog.rvSpecificationCategory.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            specificationItemClick(0,dialog)
            specificationCategoryAdapter = SpecificationCategoryAdapter(this,categoryType)
            dialog.rvSpecificationCategory.adapter = specificationCategoryAdapter

            dialog.rvSpecification.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
            specificationType.clear()
            specificationType.add(VehicleListModel("Engine",R.drawable.ic_engine))
            specificationType.add(VehicleListModel("Body Dimensions",R.drawable.ic_body_dimension))
            specificationType.add(VehicleListModel("Chasis & Suspensions",R.drawable.ic_suspensions))
            specificationType.add(VehicleListModel("Types & Brakes",R.drawable.ic_tyres))
            specificationType.add(VehicleListModel("Electricals",R.drawable.ic_electricals))
            specificationAdapter = SpecificationAdapter(this,specificationType,{position : Int -> specificationItemClick(position,dialog) })
            dialog.rvSpecification.adapter = specificationAdapter

        }
    }
}
package com.example.vechilelayout.view

import android.app.Dialog
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vechilelayout.R
import com.example.vechilelayout.adapter.*
import com.example.vechilelayout.model.VehicleListModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
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
    lateinit var vehicleVariantAdapter: VehicleVariantAdapter

    var videoReviewList = ArrayList<VehicleListModel>()
    var similarBikeList = ArrayList<VehicleListModel>()
    var colorList = ArrayList<Drawable>()
    var imageList = ArrayList<Int>()
    var categoryType = ArrayList<VehicleListModel>()
    var specificationType = ArrayList<VehicleListModel>()
    var vehicleVariantList = ArrayList<VehicleListModel>()

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

        vehicleVariantList.add(VehicleListModel("Fireball"))
        vehicleVariantList.add(VehicleListModel("Stellar"))
        vehicleVariantList.add(VehicleListModel("Supernova"))

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

        vehicleVariantAdapter = VehicleVariantAdapter(this,vehicleVariantList)
        rvVariant.adapter = vehicleVariantAdapter

        tvPriceBreakUp.setOnClickListener {
            sheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        bottomSheetTT.ivClose.setOnClickListener {
            with(sheetBehavior) { setPeekHeight(0,false) }
            sheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        tvColor.setOnClickListener {
            rvColor.visibility = View.VISIBLE
            rvVariant.visibility = View.GONE
            tvColor.setTextColor(ContextCompat.getColor(this,R.color.white))
            tvColor.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.green_400))
            tvVariant.setTextColor(ContextCompat.getColor(this,R.color.grey_login_new))
            tvVariant.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.bg_variant))
        }

        tvVariant.setOnClickListener {
            rvColor.visibility = View.GONE
            rvVariant.visibility = View.VISIBLE
            tvVariant.setTextColor(ContextCompat.getColor(this,R.color.white))
            tvVariant.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.green_400))
            tvColor.setTextColor(ContextCompat.getColor(this,R.color.grey_login_new))
            tvColor.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this,R.color.bg_variant))
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 ->{
                        scrollView.scrollTo(0,clPrice.y.toInt())
                    }
                    1 ->{
                        scrollView.scrollTo(0,clSpecification.y.toInt())
                    }
                    2->{
                        scrollView.scrollTo(0,clVideoReview.y.toInt())
                    }
                    3->{
                        scrollView.scrollTo(0,clSimilarBikes.y.toInt())
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

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
            dialog.toolBarTitle.text = "SPECIFICATION"
            dialog.show()
            dialog.toolBarIcon.setOnClickListener {
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
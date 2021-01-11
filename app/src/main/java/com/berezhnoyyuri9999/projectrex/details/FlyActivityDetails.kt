package com.berezhnoyyuri9999.projectrex.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berezhnoyyuri9999.projectrex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fly_details.*
import kotlinx.android.synthetic.main.activity_swim_details.*
import kotlinx.android.synthetic.main.activity_swim_details.product_nameSwim
import kotlinx.android.synthetic.main.activity_swim_details.tv_description1Swim
import kotlinx.android.synthetic.main.activity_swim_details.tv_description2Swim
import kotlinx.android.synthetic.main.activity_swim_details.tv_detailSwim
import kotlinx.android.synthetic.main.activity_swim_details.tv_takenSwim

class FlyActivityDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fly_details)
        //
        val titleFly = intent.getStringExtra("titleFly")
        val detailFly = intent.getStringExtra("detailFly")
        val description1Fly = intent.getStringExtra("description1Fly")
        val description2Fly = intent.getStringExtra("description2Fly")

        val takenFly = intent.getStringExtra("takenFly")

        val photoUrlFly = intent.getStringExtra("photo_urlFly")

        /////////
        val photoCompareFly = intent.getStringExtra("photoCompare")
        Picasso.get().load(photoCompareFly).into(im_compareFly)
        /////////

        Picasso.get().load(photoUrlFly).into(photoFly)

        product_nameFly.text = titleFly
        tv_detailFly.text = detailFly
        tv_description1Fly.text = description1Fly
        tv_description2Fly.text = description2Fly

        tv_takenFly.text = takenFly
    }
}
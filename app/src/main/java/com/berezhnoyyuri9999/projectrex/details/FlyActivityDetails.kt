package com.berezhnoyyuri9999.projectrex.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berezhnoyyuri9999.projectrex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fly_details.*

class FlyActivityDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fly_details)
        getData()
    }

    private fun getData() {
        val titleFly = intent.getStringExtra("title")
        val detailFly = intent.getStringExtra("detail")
        val description1Fly = intent.getStringExtra("description1")
        val description2Fly = intent.getStringExtra("description2")
        val takenFly = intent.getStringExtra("taken")
        val photoUrlFly = intent.getStringExtra("photo_url")
        val photoCompareFly = intent.getStringExtra("photoCompare")

        Picasso.get().load(photoCompareFly).into(im_compareFly)
        Picasso.get().load(photoUrlFly).into(photoFly)

        product_nameFly.text = titleFly
        tv_detailFly.text = detailFly
        tv_description1Fly.text = description1Fly
        tv_description2Fly.text = description2Fly
        tv_takenFly.text = takenFly
    }
}
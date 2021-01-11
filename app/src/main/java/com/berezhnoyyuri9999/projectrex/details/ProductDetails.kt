package com.berezhnoyyuri9999.projectrex.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berezhnoyyuri9999.projectrex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_fly_details.*
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val title = intent.getStringExtra("title")
        val detail = intent.getStringExtra("detail")
        val description1 = intent.getStringExtra("description1")
        val description2 = intent.getStringExtra("description2")

        val taken = intent.getStringExtra("taken")

        val photoUrl = intent.getStringExtra("photo_url")
        Picasso.get().load(photoUrl).into(photo)

        /////////
        val photoCompareRus = intent.getStringExtra("photoCompare")
        Picasso.get().load(photoCompareRus).into(im_compare)
        /////////

        product_name.text = title
        tv_detail.text = detail
        tv_description1.text = description1
        tv_description2.text = description2

        tv_taken.text = taken
    }
}
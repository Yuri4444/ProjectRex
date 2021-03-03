package com.berezhnoyyuri9999.projectrex.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.berezhnoyyuri9999.projectrex.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_swim_details.*

class SwimActivityDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swim_details)

        val titleSwim = intent.getStringExtra("titleSwim")
        val detailSwim = intent.getStringExtra("detailSwim")
        val description1Swim = intent.getStringExtra("description1Swim")
        val description2Swim = intent.getStringExtra("description2Swim")
        val takenSwim = intent.getStringExtra("takenSwim")
        val photoUrlSwim = intent.getStringExtra("photo_urlSwim")
        Picasso.get().load(photoUrlSwim).into(photoSwim)

        product_nameSwim.text = titleSwim
        tv_detailSwim.text = detailSwim
        tv_description1Swim.text = description1Swim
        tv_description2Swim.text = description2Swim
        tv_takenSwim.text = takenSwim
    }
}
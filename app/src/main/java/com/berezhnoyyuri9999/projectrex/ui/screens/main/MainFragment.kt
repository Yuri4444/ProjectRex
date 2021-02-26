package com.berezhnoyyuri9999.projectrex.ui.screens.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.berezhnoyyuri9999.projectrex.NavControllerBridge
import com.berezhnoyyuri9999.projectrex.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.product_row.*

class MainFragment : Fragment(R.layout.fragment_main) {

    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(context, R.anim.to_bottom_anim) }
    private var clicked = false

    private lateinit var mNavController : NavControllerBridge

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mNavController = context as NavControllerBridge

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fab_language.setOnClickListener {
            onAddButtonClicked()
        }

        fab_england.setOnClickListener {
            mNavController.navController().navigate(R.id.action_mainFragment_to_landEnglishFragment)

        }

        fab_russia.setOnClickListener {
            mNavController.navController().navigate(R.id.action_mainFragment_to_landRussianFragment)
        }

        fab_fly.setOnClickListener {
            onAddButtonClickedFly()
        }

        fab_england_fly.setOnClickListener {

            mNavController.navController().navigate(R.id.action_mainFragment_to_flyEnglishFragment)
        }

        fab_russia_fly.setOnClickListener {
            mNavController.navController().navigate(R.id.action_mainFragment_to_flyRussianFragment)
        }

        fab_marine.setOnClickListener {
            onAddButtonClickedSwim()
        }

        fab_england_swim.setOnClickListener {
            mNavController.navController().navigate(R.id.action_mainFragment_to_swimEnglishFragment)
        }

        fab_russia_swim.setOnClickListener {
            mNavController.navController().navigate(R.id.action_mainFragment_to_swimRussianFragment)
        }

    }

    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            fab_england.visibility = View.VISIBLE
            fab_russia.visibility = View.VISIBLE
        } else {
            fab_england.visibility = View.INVISIBLE
            fab_russia.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            fab_england.startAnimation(fromBottom)
            fab_russia.startAnimation(fromBottom)

        } else {
            fab_england.startAnimation(toBottom)
            fab_russia.startAnimation(toBottom)
        }
    }

    private fun setClickable(clicked: Boolean) {
        if (!clicked) {
            fab_england.isClickable = true
            fab_russia.isClickable = true
        } else {
            fab_england.isClickable = false
            fab_russia.isClickable = false
        }
    }

    private fun onAddButtonClickedFly() {
        setVisibilityFly(clicked)
        setAnimationFly(clicked)
        setClickableFly(clicked)
        clicked = !clicked
    }

    private fun setVisibilityFly(clicked: Boolean) {
        if (!clicked) {
            fab_england_fly.visibility = View.VISIBLE
            fab_russia_fly.visibility = View.VISIBLE
        } else {
            fab_england_fly.visibility = View.INVISIBLE
            fab_russia_fly.visibility = View.INVISIBLE
        }
    }

    private fun setAnimationFly(clicked: Boolean) {
        if (!clicked) {
            fab_england_fly.startAnimation(fromBottom)
            fab_russia_fly.startAnimation(fromBottom)
        } else {
            fab_england_fly.startAnimation(toBottom)
            fab_russia_fly.startAnimation(toBottom)
        }
    }

    private fun setClickableFly(clicked: Boolean) {
        if (!clicked) {
            fab_england_fly.isClickable = true
            fab_russia_fly.isClickable = true
        } else {
            fab_england_fly.isClickable = false
            fab_russia_fly.isClickable = false
        }
    }

    private fun onAddButtonClickedSwim() {
        setVisibilitySwim(clicked)
        setAnimationSwim(clicked)
        setClickableSwim(clicked)
        clicked = !clicked
    }

    private fun setVisibilitySwim(clicked: Boolean) {
        if (!clicked) {
            fab_england_swim.visibility = View.VISIBLE
            fab_russia_swim.visibility = View.VISIBLE
        } else {
            fab_england_swim.visibility = View.INVISIBLE
            fab_russia_swim.visibility = View.INVISIBLE
        }
    }

    private fun setAnimationSwim(clicked: Boolean) {
        if (!clicked) {
            fab_england_swim.startAnimation(fromBottom)
            fab_russia_swim.startAnimation(fromBottom)
        } else {
            fab_england_swim.startAnimation(toBottom)
            fab_russia_swim.startAnimation(toBottom)
        }
    }

    private fun setClickableSwim(clicked: Boolean) {
        if (!clicked) {
            fab_england_swim.isClickable = true
            fab_russia_swim.isClickable = true
        } else {
            fab_england_swim.isClickable = false
            fab_russia_swim.isClickable = false
        }
    }

}
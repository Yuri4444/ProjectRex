package com.berezhnoyyuri9999.projectrex

//import com.berezhnoyyuri9999.projectrex.cardSwim.SwimFragment


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.berezhnoyyuri9999.projectrex.cardSwim.FlyFragment
import com.berezhnoyyuri9999.projectrex.cardSwim.SwimFragment
import com.berezhnoyyuri9999.projectrex.fragments.*
import com.berezhnoyyuri9999.projectrex.language.FlyRussianFragment
import com.berezhnoyyuri9999.projectrex.language.RussianFragment
import com.berezhnoyyuri9999.projectrex.language.SwimRussianFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    /////////Наземные
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this,
            R.anim.to_bottom_anim
        )
    }

    private var clicked = false

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
//            fab_language.startAnimation(rotateOpen)
        } else {
            fab_england.startAnimation(toBottom)
            fab_russia.startAnimation(toBottom)
//            fab_language.startAnimation(rotateClose)
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
/////////Наземные


    /////////Воздух
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
//            fab_language.startAnimation(rotateOpen)
        } else {
            fab_england_fly.startAnimation(toBottom)
            fab_russia_fly.startAnimation(toBottom)
//            fab_language.startAnimation(rotateClose)
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
/////////Воздух


    /////////Водные
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
//            fab_language.startAnimation(rotateOpen)
        } else {
            fab_england_swim.startAnimation(toBottom)
            fab_russia_swim.startAnimation(toBottom)
//            fab_language.startAnimation(rotateClose)
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


/////////Водные


//    val clickableButton : ClickableButton? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.frameLayout, MainFragment())
//            commit()
//
//        }
////////////////// Языки НАЗЕМНЫЕ
        fab_language.setOnClickListener {
            onAddButtonClicked()
//            clickableButton?.onAddButtonClicked()
        }

        fab_england.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, MainFragment())
                commit()

            }
        }


        fab_russia.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, RussianFragment())
                commit()
            }
        }
        ////////////////// Языки НАЗЕМНЫЕ


        ////////////////// Языки ВОЗДУХ
        fab_fly.setOnClickListener {
            onAddButtonClickedFly()
//            clickableButton?.onAddButtonClicked()
        }

        fab_england_fly.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, FlyFragment())
                commit()

            }
        }



        fab_russia_fly.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, FlyRussianFragment())
                commit()
            }
        }
        ////////////////// Языки ВОЗДУХ


        ////////////////// Языки Водные
        fab_marine.setOnClickListener {
            onAddButtonClickedSwim()
//            clickableButton?.onAddButtonClicked()
        }

        fab_england_swim.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, SwimFragment())
                commit()

            }
        }


        fab_russia_swim.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, SwimRussianFragment())
                commit()
            }
        }

        ////////////////// Языки Водные


        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.plant -> supportFragmentManager.beginTransaction().apply {
                    addToBackStack(null)
                    replace(R.id.frameLayout, PlantFragment())
                    commit()
                }
                R.id.earth -> supportFragmentManager.beginTransaction().apply {
                        addToBackStack(null)
                        replace(R.id.frameLayout, HistoryFragment())
                        commit()
                }
                R.id.records -> supportFragmentManager.beginTransaction().apply {
                    addToBackStack(null)
                    replace(R.id.frameLayout, RecordsFragment())
                    commit()
                }
                R.id.finds -> {
                    supportFragmentManager.beginTransaction().apply {
                        addToBackStack(null)
                        replace(R.id.frameLayout, FindFragment())
                        commit()
                    }

                }

                R.id.skeleton -> {
                    supportFragmentManager.beginTransaction().apply {
                        addToBackStack(null)
                        replace(R.id.frameLayout, SkeletonFragment())
                        commit()
                    }
                }
            }

            it.isChecked = true
            drawerLayout.closeDrawers()

            true
        }

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)

        }

        //Експеримент картинки
        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.itemIconTintList = null

//        val fab: Button = findViewById(R.id.fab_language)
//        fab.background = null
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_swim) {
//            supportFragmentManager.beginTransaction().apply {
//                addToBackStack(null)
//                replace(R.id.frameLayout, SwimFragment())
//                commit()
//
//            }
//
//            return true
//        }

//        if (item.itemId == R.id.menu_fly) {
//            supportFragmentManager.beginTransaction().apply {
//                addToBackStack(null)
//                replace(R.id.frameLayout, FlyFragment())
//                commit()
//
//            }
//            return true
//        }


        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_swim, menu)
        return true

    }
}
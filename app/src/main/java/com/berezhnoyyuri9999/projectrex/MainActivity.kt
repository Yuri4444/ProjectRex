package com.berezhnoyyuri9999.projectrex

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.berezhnoyyuri9999.projectrex.fragments.FindFragment
import com.berezhnoyyuri9999.projectrex.fragments.MainFragment
import com.berezhnoyyuri9999.projectrex.model.Product
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frameLayout, MainFragment())
            commit()
        }


//        fab.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.frameLayout, MainFragment())
//                commit()
//            }
//        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.plant -> Toast.makeText(this, "asfasfa", Toast.LENGTH_SHORT).show()
                R.id.earth -> Toast.makeText(this, "asfasfa", Toast.LENGTH_SHORT).show()
                R.id.records -> Toast.makeText(this, "asfasfa", Toast.LENGTH_SHORT).show()
                R.id.finds -> {
                    supportFragmentManager.beginTransaction().apply {
                        addToBackStack(null)
                        add(R.id.frameLayout, FindFragment())
                        commit()
                    }
                    Toast.makeText(this, "asfasfa", Toast.LENGTH_SHORT).show()
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
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }
}
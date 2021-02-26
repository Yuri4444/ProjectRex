package com.berezhnoyyuri9999.projectrex

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.berezhnoyyuri9999.projectrex.ui.screens.land.skeletons.SkeletonFragment
import com.berezhnoyyuri9999.projectrex.ui.screens.menuFragments.FindFragment
import com.berezhnoyyuri9999.projectrex.ui.screens.menuFragments.HistoryFragment
import com.berezhnoyyuri9999.projectrex.ui.screens.menuFragments.PlantFragment
import com.berezhnoyyuri9999.projectrex.ui.screens.menuFragments.records.RecordsFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity(), NavControllerBridge {

    private lateinit var mToolbar: Toolbar
    private val mNavController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addToolbar()
        addNavigationView()
        addButtonBurger()
    }

    private fun addNavigationView() {
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.plant -> supportFragmentManager.beginTransaction().apply { addToBackStack(null).replace(R.id.nav_host_fragment, PlantFragment()).commit() }
                R.id.earth -> supportFragmentManager.beginTransaction().apply { addToBackStack(null).replace(R.id.nav_host_fragment, HistoryFragment()).commit() }
                R.id.records -> supportFragmentManager.beginTransaction().apply { addToBackStack(null).replace(R.id.nav_host_fragment, RecordsFragment()).commit() }
                R.id.finds -> supportFragmentManager.beginTransaction().apply { addToBackStack(null).replace(R.id.nav_host_fragment, FindFragment()).commit() }
                R.id.skeleton -> supportFragmentManager.beginTransaction().apply { addToBackStack(null).replace(R.id.nav_host_fragment, SkeletonFragment()).commit() }
            }

            it.isChecked = true
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun addToolbar() {
        mToolbar = toolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.main_title)

        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.itemIconTintList = null
    }

    private fun addButtonBurger() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun navController(): NavController {
        return mNavController
    }

}

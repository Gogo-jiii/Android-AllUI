package com.example.allui.navigationdrawer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.allui.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigation_drawer.*
import kotlinx.android.synthetic.main.fragment_toolbar.view.*


class NavigationDrawerActivity : AppCompatActivity() {

    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_drawer)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentNavDrawerContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupToolbar()
    }

    private fun setupToolbar() {
        ToolbarManager.getInstance().setupNavigationDrawer(
            this, navController, toolbar2, drawer_layout, nav_view
        )
    }


    //This is required for toolbar back arrow navigation
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(
                this,
                R.id.fragmentNavDrawerContainerView
            ), drawer_layout
        )
    }

    //This is required for device's back button navigation
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
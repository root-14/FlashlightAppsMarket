package com.root14.flashlightappsmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import com.root14.flashlightappsmarket.databinding.ActivityMainBinding
import com.root14.flashlightappsmarket.model.CategoryType
import com.root14.flashlightappsmarket.view.ui.mainFragment.MainFragmentDirections
import com.root14.flashlightappsmarket.viewmodel.ApplicationFragmentViewModel
import com.root14.flashlightappsmarket.viewmodel.MainFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //drawer layout
        drawerLayout = binding.myDrawerLayout
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        //drawer menu
        binding.navigationView.setNavigationItemSelectedListener { item ->
            val action = MainFragmentDirections.actionMainFragmentToApplicationFragment()
            when (item.itemId) {
                R.id.menu_flashlights -> {

                    action.categoryType = CategoryType.FLASHLIGHTS
                    navController.navigate(action)
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.menu_colored_lights -> {
                    action.categoryType = CategoryType.COLOREDLIGHTS
                    navController.navigate(action)
                    drawerLayout.closeDrawers()
                    true
                }

                R.id.menu_sos_alerts -> {
                    action.categoryType = CategoryType.SOSALERTS
                    navController.navigate(action)
                    drawerLayout.closeDrawers()
                    true
                }

                else -> {
                    //TODO: not implemented yet
                    true
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //TODO:if its not in application fragment false here
        val some = false
        if (some) {
            menuInflater.inflate(R.menu.main_menu, menu)
            return true
        } else {
            return super.onCreateOptionsMenu(menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}
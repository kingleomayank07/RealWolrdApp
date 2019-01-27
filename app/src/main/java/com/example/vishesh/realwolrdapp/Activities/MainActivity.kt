package com.example.vishesh.realwolrdapp.Activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.vishesh.realwolrdapp.Fragments.Home.HomeFragment
import com.example.vishesh.realwolrdapp.Fragments.article.EditFragmentArticle
import com.example.vishesh.realwolrdapp.Fragments.auth.LoginFragment
import com.example.vishesh.realwolrdapp.Fragments.auth.RegisterFragment
import com.example.vishesh.realwolrdapp.Fragments.user.SettingsFragment
import com.example.vishesh.realwolrdapp.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout,HomeFragment.newInstance()).commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.menu_item_home -> HomeFragment.newInstance()
            R.id.menu_item_new_article -> EditFragmentArticle.newInstance()
            R.id.menu_item_settings -> SettingsFragment.newInstance()
            R.id.menu_item_signin -> LoginFragment.newInstance()
            R.id.menu_item_signup -> RegisterFragment.newInstance()
            else -> HomeFragment.newInstance()
        }.let {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, it)
                .commit()
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
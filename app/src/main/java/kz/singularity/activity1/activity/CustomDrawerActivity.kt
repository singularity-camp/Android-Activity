package kz.singularity.activity1.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kz.singularity.activity1.R
import kz.singularity.activity1.activity.ui.gallery.GalleryFragment
import kz.singularity.activity1.activity.ui.home.HomeFragment
import kz.singularity.activity1.activity.ui.slideshow.SlideshowFragment

class CustomDrawerActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_custom)
        assignViews()
        setupActionBar()
        setupNavView()
        setupActionBarToggle()
        showFragment(HomeFragment())
    }

    private fun assignViews() {
        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.dl_main)
        navView = findViewById(R.id.nav_view)
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupNavView() {
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> showFragment(HomeFragment())
                R.id.nav_gallery -> showFragment(GalleryFragment())
                R.id.nav_slideshow -> showFragment(SlideshowFragment())
            }

            drawerLayout.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .commit()
    }

    private fun setupActionBarToggle() {
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.nav_opened,
            R.string.nav_closed
        )
        actionBarDrawerToggle.isDrawerIndicatorEnabled = true
        actionBarDrawerToggle.syncState()
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }
}
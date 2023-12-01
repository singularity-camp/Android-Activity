package kz.singularity.activity1.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast

class ToolbarActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var btnOpen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        assignViews()
        setSupportActionBar(toolbar)
        setupClickListeners()
    }

    private fun assignViews() {
        toolbar = findViewById(R.id.toolbar)
        btnOpen = findViewById(R.id.btn_open)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_android) {
            showToast("Android clicked")
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupClickListeners() {
        btnOpen.setOnClickListener {
            startActivity(Intent(this, SecondToolbarActivity::class.java))
        }
    }
}
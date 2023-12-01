package kz.singularity.activity1.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast

class ToolbarActivity : AppCompatActivity() {

    private val TAG = "ToolbarActivity"

    lateinit var toolbar: Toolbar
    lateinit var btnOpen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        assignViews()
        setSupportActionBar(toolbar)
        setupClickListeners()

        registerForContextMenu(btnOpen)
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

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        Log.d(TAG, "View for registration = $v")
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_android) {
            showToast("Android clicked from context menu")
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
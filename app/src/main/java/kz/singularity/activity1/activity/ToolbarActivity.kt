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
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar
import kz.singularity.activity1.R
import kz.singularity.activity1.showToast

class ToolbarActivity : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    private val TAG = "ToolbarActivity"

    lateinit var toolbar: Toolbar
    lateinit var btnOpenContextMenu: Button
    lateinit var btnOpenPopupMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        assignViews()
        setSupportActionBar(toolbar)
        setupClickListeners()

        registerForContextMenu(btnOpenContextMenu)
    }

    private fun assignViews() {
        toolbar = findViewById(R.id.toolbar)
        btnOpenContextMenu = findViewById(R.id.btn_open_context_menu)
        btnOpenPopupMenu = findViewById(R.id.btn_open_popup_menu)
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
        val popupMenu = PopupMenu(this, btnOpenPopupMenu)
        popupMenu.menuInflater.inflate(R.menu.menu_main, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener(this)

        btnOpenPopupMenu.setOnClickListener {
            popupMenu.show()
        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        if (item == null) {
            return false
        }

        if (item.itemId == R.id.menu_android) {
            showToast("Android clicked from popup menu")
            return true
        }

        return false
    }
}
package kz.singularity.activity1.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kz.singularity.activity1.R

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

    private fun setupClickListeners() {
        btnOpen.setOnClickListener {
            startActivity(Intent(this, SecondToolbarActivity::class.java))
        }
    }
}
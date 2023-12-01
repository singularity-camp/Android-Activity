package kz.singularity.activity1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kz.singularity.activity1.R

class ToolbarActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)
        assignViews()
        setSupportActionBar(toolbar)
    }

    private fun assignViews() {
        toolbar = findViewById(R.id.toolbar)
    }
}
package kz.singularity.activity1.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.singularity.activity1.R
import kz.singularity.activity1.adapters.NameAdapter

class RecyclerActivity : AppCompatActivity(R.layout.activity_recycler) {

    lateinit var rvNames: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assignViews()
        setupRecyclerView()
    }

    private fun assignViews() {
        rvNames = findViewById(R.id.rv_name)
    }

    private fun setupRecyclerView() {
        val nameAdapter = NameAdapter()
        val layoutManager = LinearLayoutManager(this)

        rvNames.adapter = nameAdapter
        rvNames.layoutManager = layoutManager
    }

}
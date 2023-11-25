package kz.singularity.activity1.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.singularity.activity1.R
import kz.singularity.activity1.adapters.name.NameAdapter
import kz.singularity.activity1.adapters.name.NameClickListener
import kz.singularity.activity1.showToast

class RecyclerActivity : AppCompatActivity(R.layout.activity_recycler), NameClickListener {

    val TAG = "RecyclerActivity"

    lateinit var rvNames: RecyclerView
    lateinit var btnUpdate: Button

    lateinit var nameAdapter: NameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assignViews()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun assignViews() {
        rvNames = findViewById(R.id.rv_name)
        btnUpdate = findViewById(R.id.btn_update)
    }

    private fun setupRecyclerView() {
        nameAdapter = NameAdapter(this)
        val layoutManager = LinearLayoutManager(this)

        rvNames.adapter = nameAdapter
        rvNames.layoutManager = layoutManager
    }

    private fun setupClickListeners() {
        btnUpdate.setOnClickListener {
            nameAdapter.setData((1..100).toList().map { it.toString() })
            //nameAdapter.notifyDataSetChanged()
        }
    }

    override fun onNameClick(name: String) {
        showToast("Clicked on $name")
    }

}
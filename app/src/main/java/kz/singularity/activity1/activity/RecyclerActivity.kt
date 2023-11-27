package kz.singularity.activity1.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kz.singularity.activity1.R
import kz.singularity.activity1.adapters.name.NameAdapter
import kz.singularity.activity1.adapters.name.NameClickListener
import kz.singularity.activity1.adapters.name.NamesListAdapter
import kz.singularity.activity1.showToast

class RecyclerActivity : AppCompatActivity(R.layout.activity_recycler), NameClickListener {

    val TAG = "RecyclerActivity"

    lateinit var rvNames: RecyclerView
    lateinit var btnUpdate: Button
    lateinit var btnAdd: Button
    lateinit var btnScroll: Button

    lateinit var nameAdapter: NamesListAdapter

    val numbers: MutableList<String> = (1..100).map { it.toString() }.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        assignViews()
        setupRecyclerView()
        setupClickListeners()
    }

    private fun assignViews() {
        rvNames = findViewById(R.id.rv_name)
        btnUpdate = findViewById(R.id.btn_update)
        btnAdd = findViewById(R.id.btn_add)
        btnScroll = findViewById(R.id.btn_scroll)
    }

    private fun setupRecyclerView() {
        nameAdapter = NamesListAdapter(this)
        val layoutManager = LinearLayoutManager(this)

        rvNames.adapter = nameAdapter
        rvNames.layoutManager = layoutManager
        rvNames.itemAnimator = null
        rvNames.isVerticalScrollBarEnabled = true
    }

    private fun setupClickListeners() {
        btnUpdate.setOnClickListener {
            nameAdapter.submitList(numbers)
            //nameAdapter.notifyDataSetChanged()
        }
        btnAdd.setOnClickListener {
            numbers.add(0, "New Item")
            nameAdapter.submitList(numbers)
        }
        btnScroll.setOnClickListener {
            val scroller = LinearSmoothScroller(this)
            scroller.targetPosition = 200
            rvNames.layoutManager?.startSmoothScroll(scroller)
        }
    }

    override fun onNameClick(name: String) {
        showToast("Clicked on $name")
    }

}
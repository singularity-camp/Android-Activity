package kz.singularity.activity1.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.*
import androidx.recyclerview.widget.ItemTouchHelper.*
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

    lateinit var nameAdapter: NameAdapter

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
        nameAdapter = NameAdapter(this)
        val layoutManager = LinearLayoutManager(this)

        rvNames.adapter = nameAdapter
        rvNames.layoutManager = layoutManager
        rvNames.itemAnimator = null
        rvNames.isVerticalScrollBarEnabled = true

        itemTouchHelper.attachToRecyclerView(rvNames)


        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvNames)
        rvNames.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                snapHelper.findSnapView(layoutManager)?.let {
                    val position = layoutManager.getPosition(it)

                }
            }
        })
    }


    private fun setupClickListeners() {
        btnUpdate.setOnClickListener {
//            nameAdapter.submitList(numbers)
            nameAdapter.setData(numbers)
            nameAdapter.notifyDataSetChanged()
        }
        btnAdd.setOnClickListener {
//            numbers.add(0, "New Item")
//            nameAdapter.submitList(numbers)
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


    private val itemTouchHelper by lazy {
        ItemTouchHelper(object : SimpleCallback(UP or DOWN, START or END) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val adapter = recyclerView.adapter as NameAdapter
                val from = viewHolder.adapterPosition
                val to = target.adapterPosition

                adapter.moveItem(from, to)
                adapter.notifyItemMoved(from, to)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                Log.d("ItemTOuchHelper", "Swiped to direction = $direction")
                val position = viewHolder.adapterPosition
                numbers.removeAt(position)
                nameAdapter.notifyItemRemoved(position)
            }
        })
    }
}
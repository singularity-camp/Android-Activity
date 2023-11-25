package kz.singularity.activity1.adapters.name

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.singularity.activity1.R

class NameAdapter(private val onNameClickListener: NameClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TAG = "NameAdapter"

    private val VIEW_TYPE_ODD = 0
    private val VIEW_TYPE_EVEN = 1

    private val names = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder. ViewType = $viewType")
        //Create inflater
        //Inflate layout using it and store in value

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = if (viewType == VIEW_TYPE_ODD) {
            layoutInflater.inflate(R.layout.item_name_odd, parent, false)
        } else {
            layoutInflater.inflate(R.layout.item_name_even, parent, false)
        }
        //Return new ViewHolder where you pass your newly create view
        return NameViewHolder(view, onNameClickListener)
    }

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_EVEN
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder, position = $position")
        val name = names[position]
        if (holder is NameViewHolder) {
            holder.bind(name = name, position = position)
        }
//        if (holder is //InstanceOfAnotherViewHolder) {
//
//          }
    }


    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount")
        return names.size
    }

    fun setData(newNames: List<String>) {
        names.clear()
        names.addAll(newNames)
        notifyDataSetChanged()
    }

    fun addItemToPosition(name: String, position: Int) {
        names.add(position, name, )
        notifyItemInserted(position)
    }
}


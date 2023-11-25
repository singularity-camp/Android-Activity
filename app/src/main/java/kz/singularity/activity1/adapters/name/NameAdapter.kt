package kz.singularity.activity1.adapters.name

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.singularity.activity1.R

class NameAdapter(private val onNameClickListener: NameClickListener) :
    RecyclerView.Adapter<NameViewHolder>() {
    val TAG = "NameAdapter"
//
//    private val names = listOf("Арман", "Игорь", "Daniel", "Айсұлу")
//    private val numbers = (1..100).toList().map { it.toString() }

    private val names = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        Log.d(TAG, "onCreateViewHolder")
        //Create inflater
        //Inflate layout using it and store in value

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_name, parent, false)
        //Return new ViewHolder where you pass your newly create view
        return NameViewHolder(view, onNameClickListener)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder, position = $position")
        val name = names[position]

        holder.bind(name = name, position = position)
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
}


package kz.singularity.activity1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kz.singularity.activity1.R

class NameAdapter : RecyclerView.Adapter<NameViewHolder>() {
    val names = listOf("Арман", "Игорь", "Daniel", "Айсұлу")
    val numbers = (1..100).toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        //Create inflater
        //Inflate layout using it and store in value

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_name, parent, false)
        //Return new ViewHolder where you pass your newly create view
        return NameViewHolder(view)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.tvName.text = numbers[position].toString()
    }


    override fun getItemCount(): Int {
        return numbers.size
    }
}

class NameViewHolder(view: View) : ViewHolder(view) {
    val tvName: TextView = view.findViewById(R.id.tv_name)
}
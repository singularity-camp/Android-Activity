package kz.singularity.activity1.adapters.name

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.singularity.activity1.R

class NameViewHolder(
    view: View,
    private val onNameClickListener: NameClickListener
) : RecyclerView.ViewHolder(view) {
    val tvName: TextView = view.findViewById(R.id.tv_name)

    fun bind(name: String, position: Int) {
        tvName.text = name

        if (position % 2 == 1) {
            tvName.setBackgroundColor(Color.CYAN)
        } else {
            tvName.setBackgroundColor(Color.TRANSPARENT)
        }

        itemView.setOnClickListener {
            onNameClickListener.onNameClick(name)
        }
    }
}
package kz.singularity.activity1.adapters.name

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kz.singularity.activity1.R
import kz.singularity.activity1.models.User

class NamesListAdapter(private val onNameClickListener: NameClickListener) :
    ListAdapter<String, NameViewHolder>(NamesDiffUtilCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        //Create inflater
        //Inflate layout using it and store in value

        val layoutInflater = LayoutInflater.from(parent.context)

        val view = layoutInflater.inflate(R.layout.item_name, parent, false)
        //Return new ViewHolder where you pass your newly create view
        return NameViewHolder(view, onNameClickListener)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val name = getItem(position)

        holder.bind(name = name, position = position)
    }
}

class NamesDiffUtilCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}

class UserDiffUtilItemCallback : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}
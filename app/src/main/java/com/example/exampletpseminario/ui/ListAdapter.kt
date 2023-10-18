package com.example.exampletpseminario.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampletpseminario.databinding.ItemListRecyclerviewBinding
import com.example.exampletpseminario.model.User
import com.example.exampletpseminario.model.UserExample


class ListAdapter() : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var userList = emptyList<User>()


    inner class ListViewHolder(private val binding: ItemListRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvId.text = user.id.toString()
            binding.tvFirstName.text = user.firstName
            binding.tvLastName.text = user.lastName
            binding.tvAge.text = user.age.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemListRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding = binding)
    }

    //override fun getItemCount(): Int = userList.size
    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        //holder.binding.tvIdUser.text = userList.get(position).id.toString()
        val user = userList.get(position)
        holder.bind(user)

    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }

}
package com.example.exampletpseminario

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampletpseminario.databinding.ItemListRecyclerviewBinding
import com.example.exampletpseminario.model.User


class ListAdapter(private val userList: List<User>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(private val binding: ItemListRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.tvIdUser.text = user.id.toString()
            binding.tvTitleUser.text = user.title
            binding.tvSubTitleUser.text = user.description
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

}
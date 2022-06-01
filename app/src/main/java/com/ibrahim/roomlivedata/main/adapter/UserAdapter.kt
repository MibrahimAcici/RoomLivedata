package com.ibrahim.roomlivedata.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ibrahim.roomlivedata.db.entity.UserEntity
import com.ibrahim.roomlivedata.databinding.UserRowBinding

class UserAdapter() : RecyclerView.Adapter<UserAdapter.UserVH>() {

    private var users: ArrayList<UserEntity> = arrayListOf()
     var removeClickListener: (UserEntity) -> Unit = {}

    fun setList(newList: List<UserEntity>) {
        this.users.clear()
        this.users.addAll(newList)
        notifyDataSetChanged()
    }

    inner class UserVH(val binding:UserRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val tvUserName = binding.rcTvName
        val tvUserAge = binding.rcTvAge
        val tvUserHeight = binding.rcTvHeight
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserVH {
        return UserVH(UserRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserVH, position: Int) {
        val user = users[position]

        holder.tvUserName.text = user.userName
        holder.tvUserAge.text = user.userAge.toString()
        holder.tvUserHeight.text = user.userHeight.toString()

        holder.itemView.setOnClickListener {
            removeClickListener.invoke(user)
        }

    }

    override fun getItemCount(): Int = users.size


}
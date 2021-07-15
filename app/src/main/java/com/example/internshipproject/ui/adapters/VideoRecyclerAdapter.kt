package com.example.internshipproject.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.internshipproject.databinding.ViewholderVideoItemBinding
import com.example.internshipproject.network.response.get.Vid

class VideoRecyclerAdapter(val list: List<Vid>) :
    RecyclerView.Adapter<VideoRecyclerAdapter.VideoViewHolder>() {

    /** ViewHolder that will hold the view which we want to display in recyclerView **/
    inner class VideoViewHolder(val binding: ViewholderVideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    /** this function will create the viewHolder **/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding =
            ViewholderVideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    /** this function will load data to the view **/
    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val binding = holder.binding
        Log.e("VideoAdapter",list[position].thumbnail)
        Glide.with(holder.itemView).load(list[position].thumbnail).into(binding.thumbnail)
        binding.title.text = list[position].text
    }

    /** this function will help the recylerView in knowing the total items **/
    override fun getItemCount() = list.size
}
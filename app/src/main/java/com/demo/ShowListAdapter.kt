package com.demo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.databinding.ItemBinding

class ShowListAdapter : RecyclerView.Adapter<ShowListAdapter.ViewHolder>() {
    var listVideos = mutableListOf<VideoModel>()
    inner class ViewHolder(val binding: ItemBinding): RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            binding.apply {
                item = listVideos[position]
            }
        }
    }

    override fun getItemCount(): Int = listVideos.size
}
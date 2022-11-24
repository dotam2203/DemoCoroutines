package com.demo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.databinding.ActivityListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count

class ListActivity : AppCompatActivity(){
    private lateinit var binding : ActivityListBinding
    var listAdapter = ShowListAdapter()
    var videos = ArrayList<VideoModel>()
    var video =  VideoModel()
    val viewModel: ViewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        //initViewModel()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initViewModel(){
        viewModel.getListVideos()
        lifecycleScope.launchWhenCreated {
            viewModel.videos.collect {
                if(it.isNotEmpty()){
                    listAdapter.listVideos.clear()
                    listAdapter.listVideos.addAll(it)
                    videos.addAll(it)
                    listAdapter.notifyDataSetChanged()
                }
                else{
                    listAdapter.apply {
                        listVideos.clear()
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }
    private fun initAdapter(){
        binding.apply {
            rvVideo.apply {
                layoutManager = LinearLayoutManager(this@ListActivity)
                adapter = listAdapter
            }
        }
    }
}
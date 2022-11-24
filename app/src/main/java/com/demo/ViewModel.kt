package com.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
/**
 * Author: tamdt35@fpt.com.vn
 * Date:  21/11/2022
 */
class ViewModel : ViewModel(){
    private val videoRepository = VideoRepository()
    private val _videos = MutableStateFlow(emptyList<VideoModel>())
    val videos : StateFlow<List<VideoModel>> = _videos
    private val _video : MutableStateFlow<VideoModel?> = MutableStateFlow(null)
    val video : StateFlow<VideoModel?> = _video
    fun getListVideos(){
        viewModelScope.launch {
            videoRepository.getListVideos().collect{
                if(it.isSuccessful)
                    _videos.value = it.body() ?: emptyList()
            }
        }
    }
}
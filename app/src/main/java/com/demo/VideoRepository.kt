package com.demo

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  23/11/2022
 */
class VideoRepository {
    suspend fun getListVideos(): Flow<Response<List<VideoModel>>> = flow {
        val request = CallApi.loadApi.getListVideos()
        if(request.isSuccessful)
            emit(request)
    }.flowOn(IO)
}
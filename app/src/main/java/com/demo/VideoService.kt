package com.demo

import retrofit2.Response
import retrofit2.http.GET

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  23/11/2022
 */
interface VideoService {
    @GET("550?api_key=e13cc716899ae5b7470d71870624e435")
    suspend fun getListVideos(): Response<List<VideoModel>>
}
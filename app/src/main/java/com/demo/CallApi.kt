package com.demo

import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Author: tamdt35@fpt.com.vn
 * Date:  22/11/2022
 */
object CallApi {
    private val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private fun getApiUrl(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient().newBuilder().also {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            it.apply {
                addNetworkInterceptor(loggingInterceptor)
                connectTimeout(120,TimeUnit.SECONDS)
                writeTimeout(120,TimeUnit.SECONDS)
                protocols(Collections.singletonList(Protocol.HTTP_1_1))
            }
        }.build()).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val loadApi: VideoService by lazy {
        getApiUrl().create(VideoService :: class.java)
    }
}
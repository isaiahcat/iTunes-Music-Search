package com.jhaiasi.itunesmusicsearch.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.data.SearchResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {

    @GET("/search?country=PH&limit=60")
    fun searchMusic(@Query("term") keywords: String): SearchResponse

    companion object {

        private const val BASE_URL = "https://itunes.apple.com"

        fun init(): MusicService = Retrofit.Builder()
            .client(OkHttpClient().newBuilder().addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build())
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(MusicService::class.java)
    }
}
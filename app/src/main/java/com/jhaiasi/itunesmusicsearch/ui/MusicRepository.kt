package com.jhaiasi.itunesmusicsearch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhaiasi.itunesmusicsearch.data.Track
import com.jhaiasi.itunesmusicsearch.network.MusicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepository @Inject internal constructor(private val musicService: MusicService) {

    private val searchResults: MutableList<Track> = mutableListOf()
    private val _searchResults: MutableLiveData<List<Track>> = MutableLiveData()

    fun getSearchResults(): LiveData<List<Track>> = _searchResults

    fun searchMusic(keywords: String) =
        GlobalScope.launch(Dispatchers.Main) {
            val request = musicService.getSearchResultsAsync(keywords)
            try {
                val response = request.await()
                if (response.isSuccessful) {

                    searchResults.clear()

                    response.body()?.results?.let { searchResults.addAll(it) }

                    _searchResults.value = searchResults
                }
            } catch (e: Exception) {
                Log.d("MusicRepository ", e.message ?: "")
            }
        }
}
package com.jhaiasi.itunesmusicsearch.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jhaiasi.itunesmusicsearch.data.AppDatabase
import com.jhaiasi.itunesmusicsearch.data.Track
import com.jhaiasi.itunesmusicsearch.network.MusicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MusicRepository @Inject internal constructor(
    private val musicService: MusicService,
    private val appDatabase: AppDatabase
) {

    private val searchResults: MutableList<Track> = mutableListOf()
    private val _searchResults: MutableLiveData<List<Track>> = MutableLiveData()

    fun getSearchResults(): LiveData<List<Track>> = _searchResults

    suspend fun loadTracksFromDatabase() =
        repopulateSearchResults(appDatabase.trackDao().getTracks())

    fun searchMusic(keywords: String) =
        GlobalScope.launch(Dispatchers.Main) {
            val request = musicService.getSearchResultsAsync(keywords)
            try {
                val response = request.await()
                if (response.isSuccessful) {
                    response.body()?.results?.let {
                        repopulateSearchResults(it)
                        appDatabase.trackDao().insertAll(it)
                    }
                }
            } catch (e: Exception) {
                Log.d("MusicRepository ", e.message ?: "")
            }
        }

    private fun repopulateSearchResults(source: List<Track>) {
        searchResults.clear()
        searchResults.addAll(source)
        _searchResults.value = searchResults
    }
}
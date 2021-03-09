package com.jhaiasi.itunesmusicsearch.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jhaiasi.itunesmusicsearch.data.Track

/**
 * The ViewModel for [SearchFragment].
 */
class SearchViewModel @ViewModelInject internal constructor(
    private val musicRepository: MusicRepository
) : ViewModel() {

    val searchResults: LiveData<List<Track>> = musicRepository.getSearchResults()

    fun searchMusic(keywords: String) = musicRepository.searchMusic(keywords)
}
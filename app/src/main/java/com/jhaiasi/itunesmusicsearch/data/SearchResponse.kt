package com.jhaiasi.itunesmusicsearch.data

import com.jhaiasi.itunesmusicsearch.data.Track

data class SearchResponse(
    val resultCount: Int,
    val results: List<Track>
)
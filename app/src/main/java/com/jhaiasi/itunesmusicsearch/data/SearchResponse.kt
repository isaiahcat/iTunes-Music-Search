package com.jhaiasi.itunesmusicsearch.data

data class SearchResponse(
    val resultCount: Int,
    val results: List<Track>
)
package com.jhaiasi.itunesmusicsearch.data

data class Track(
    val trackId: String,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val trackPrice: Float,
    val trackExplicitness: String,
    val trackTimeMillis: String,
    val currency: String,
)
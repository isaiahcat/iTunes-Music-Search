package com.jhaiasi.itunesmusicsearch.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.util.*

@Keep
@Parcelize
data class Track(
    val trackId: String,
    val artistName: String,
    val collectionName: String,
    val trackName: String,
    val trackPrice: Float,
    val trackExplicitness: String,
    val trackTimeMillis: Long,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val releaseDate: Date,
    val currency: String,
    val primaryGenreName: String
) : Parcelable
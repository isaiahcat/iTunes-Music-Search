package com.jhaiasi.itunesmusicsearch.data

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import java.util.*

@Keep
@Parcelize
data class Track(
    val trackId: String,

    val trackName: String,
    val artistName: String,
    val collectionName: String,

    val trackPrice: Float,
    val trackExplicitness: String,
    val trackTimeMillis: Long,

    val trackViewUrl: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,

    val artworkUrl100: String,

    val currency: String,
    val releaseDate: Date,
    val primaryGenreName: String
) : Parcelable
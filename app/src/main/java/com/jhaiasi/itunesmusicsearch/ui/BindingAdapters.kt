package com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.ui

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jhaiasi.itunesmusicsearch.R
import com.jhaiasi.itunesmusicsearch.data.Track
import java.text.NumberFormat
import java.util.*

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_baseline_music_note_24)
            .error(R.drawable.ic_baseline_error_24)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}

@BindingAdapter("price")
fun bindPrice(view: TextView, track: Track?) {
    track?.let {
        val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
        format.currency = Currency.getInstance(track.currency)
        view.text = format.format(track.trackPrice)
    }
}
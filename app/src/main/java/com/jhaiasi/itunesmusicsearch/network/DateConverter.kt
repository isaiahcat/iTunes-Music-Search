package com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.network

import com.squareup.moshi.*
import java.text.SimpleDateFormat
import java.util.*

class DateConverter : JsonAdapter<Date>() {

    private val jsonDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())

    @FromJson
    override fun fromJson(reader: JsonReader): Date? =
        try {
            val dateAsString = reader.nextString()
            synchronized(jsonDateFormat) {
                jsonDateFormat.parse(dateAsString)
            }
        } catch (e: Exception) {
            null
        }

    @ToJson
    override fun toJson(writer: JsonWriter, value: Date?) {
        value?.let {
            writer.value(jsonDateFormat.format(it))
        }
    }
}
package com.jhaiasi.itunesmusicsearch.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrackDAO {
    @Query("SELECT * FROM tracks")
    fun getTracks(): List<Track>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tracks: List<Track>)
}
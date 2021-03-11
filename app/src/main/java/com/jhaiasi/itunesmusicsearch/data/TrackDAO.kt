package com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jhaiasi.itunesmusicsearch.data.Track
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackDAO {
    @Query("SELECT * FROM tracks")
    fun getTracks(): Flow<List<Track>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(tracks: List<Track>)
}
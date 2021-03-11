package com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jhaiasi.itunesmusicsearch.data.Track

@Database(entities = [Track::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun trackDao(): TrackDAO

    companion object {

        private const val DATABASE_NAME = "tracks"

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun init(context: Context): AppDatabase = instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context): AppDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}
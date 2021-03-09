package com.jhaiasi.itunesmusicsearch.com.jhaiasi.itunesmusicsearch.di

import com.jhaiasi.itunesmusicsearch.network.MusicService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideMusicService() = MusicService.init()
}
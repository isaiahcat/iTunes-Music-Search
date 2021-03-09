package com.jhaiasi.itunesmusicsearch.di

import com.jhaiasi.itunesmusicsearch.network.MusicService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideMusicService() = MusicService.init()
}
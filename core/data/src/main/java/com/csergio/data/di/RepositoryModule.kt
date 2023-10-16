package com.csergio.data.di

import com.csergio.data.datasource.TourDataSource
import com.csergio.data.repository.SettingsRepository
import com.csergio.data.repository.TourRepository
import com.csergio.domain.datasource.ITourDataSource
import com.csergio.domain.repository.ISettingsRepository
import com.csergio.domain.repository.ITourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindTourDataSource(tourDataSource: TourDataSource): ITourDataSource

    @Binds
    @Singleton
    fun bindTourRepository(tourRepository: TourRepository): ITourRepository

    @Binds
    @Singleton
    fun bindSettingsRepository(settingsRepository: SettingsRepository): ISettingsRepository

}
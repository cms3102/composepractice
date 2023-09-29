package com.csergio.data.di

import com.csergio.data.datasource.TourDataSource
import com.csergio.data.repository.TourRepository
import com.csergio.domain.datasource.ITourDataSource
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
    abstract fun bindTourDataSource(tourDataSource: TourDataSource): ITourDataSource

    @Binds
    @Singleton
    fun bindTourRepository(tourRepository: TourRepository): ITourRepository

}
package com.csergio.data.di

import com.csergio.data.datasource.CityDataSource
import com.csergio.data.repository.CityDataRepository
import com.csergio.domain.datasource.ICityDataDataSource
import com.csergio.domain.repository.ICityDataRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

//    @Binds
//    @Singleton
//    abstract fun bindCityDataDataSource(cityDataSourceImpl: CityDataSource): ICityDataDataSource

    @Provides
    @Singleton
    fun bindCityDataRepository(): ICityDataRepository {
        return CityDataRepository()
    }

}
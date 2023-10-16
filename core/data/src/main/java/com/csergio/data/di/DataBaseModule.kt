package com.csergio.data.di

import android.content.Context
import androidx.datastore.dataStore
import com.csergio.data.database.dataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) = context.dataStore
}
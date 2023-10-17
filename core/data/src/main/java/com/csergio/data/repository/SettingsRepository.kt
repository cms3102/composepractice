package com.csergio.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.csergio.data.database.themeSettingKey
import com.csergio.domain.repository.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : ISettingsRepository {
    override fun isDarkTheme(): Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[themeSettingKey] ?: false
    }

    override suspend fun saveThemeSetting(isDarkTheme: Boolean) {
        dataStore.edit {
            it.set(
                key = themeSettingKey,
                value = isDarkTheme
            )
        }
    }
}
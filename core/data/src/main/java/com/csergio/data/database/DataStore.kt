package com.csergio.data.database

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

internal val themeSettingKey = booleanPreferencesKey("theme_setting_key")

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "my_data_store")
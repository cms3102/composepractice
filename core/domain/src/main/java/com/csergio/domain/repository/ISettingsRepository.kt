package com.csergio.domain.repository

import kotlinx.coroutines.flow.Flow

interface ISettingsRepository {

    fun isDarkTheme(): Flow<Boolean>

}
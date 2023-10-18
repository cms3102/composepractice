package com.csergio.settings.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csergio.domain.usecase.LoadThemeSettingUseCase
import com.csergio.domain.usecase.SaveThemeSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    loadThemeSettingUseCase: LoadThemeSettingUseCase,
    private val saveThemeSettingUseCase: SaveThemeSettingUseCase
): ViewModel() {

    internal val isDarkTheme = loadThemeSettingUseCase.invoke()

    fun saveThemeSetting(isDarkTheme: Boolean) {
        viewModelScope.launch {
            saveThemeSettingUseCase(isDarkTheme)
        }
    }

}
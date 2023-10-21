package com.csergio.settings.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csergio.domain.usecase.LoadThemeSettingUseCase
import com.csergio.domain.usecase.SaveThemeSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
   private val loadThemeSettingUseCase: LoadThemeSettingUseCase,
    private val saveThemeSettingUseCase: SaveThemeSettingUseCase
): ViewModel() {

    private val _isDarkThemeState = MutableStateFlow(false)
    internal val isDarkThemeState: StateFlow<Boolean> = _isDarkThemeState
    init {
        loadThemeSetting()
    }
    
    private fun loadThemeSetting() {
        viewModelScope.launch {
            loadThemeSettingUseCase()
                .collectLatest {
                    _isDarkThemeState.value = it
                }
        }
    }

    fun saveThemeSetting(isDarkTheme: Boolean) {
        viewModelScope.launch {
            saveThemeSettingUseCase(isDarkTheme)
        }
    }






}
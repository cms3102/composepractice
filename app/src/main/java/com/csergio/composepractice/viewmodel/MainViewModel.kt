package com.csergio.composepractice.viewmodel

import androidx.lifecycle.ViewModel
import com.csergio.domain.usecase.LoadThemeSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    loadThemeSettingUseCase: LoadThemeSettingUseCase
) : ViewModel() {

    internal val isDarkTheme = loadThemeSettingUseCase()

}

sealed interface SplashState {
    object Showing : SplashState
    object Finished : SplashState
}
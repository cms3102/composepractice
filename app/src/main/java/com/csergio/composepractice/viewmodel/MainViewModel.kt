package com.csergio.composepractice.viewmodel

import androidx.lifecycle.ViewModel
import com.csergio.domain.usecase.ThemeSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val themeSettingUseCase: ThemeSettingUseCase
) : ViewModel() {

    internal val isDarkTheme = themeSettingUseCase.invoke()

}

sealed interface SplashState {
    object Showing : SplashState
    object Finished : SplashState
}
package com.csergio.settings.viewmodel

import androidx.lifecycle.ViewModel
import com.csergio.domain.usecase.ThemeSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themeSettingUseCase: ThemeSettingUseCase
): ViewModel() {

    internal val isDarkTheme = themeSettingUseCase.invoke()

}
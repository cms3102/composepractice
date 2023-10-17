package com.csergio.domain.usecase

import com.csergio.domain.repository.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SaveThemeSettingUseCase @Inject constructor(
    private val settingsRepository: ISettingsRepository
) {
     suspend operator fun invoke(isDarkTheme: Boolean): Unit = settingsRepository.saveThemeSetting(isDarkTheme)

}
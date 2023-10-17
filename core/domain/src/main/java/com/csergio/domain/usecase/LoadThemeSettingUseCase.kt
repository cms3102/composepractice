package com.csergio.domain.usecase

import com.csergio.domain.repository.ISettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadThemeSettingUseCase @Inject constructor(
    private val settingsRepository: ISettingsRepository
) {
     operator fun invoke(): Flow<Boolean> = settingsRepository.isDarkTheme()

}
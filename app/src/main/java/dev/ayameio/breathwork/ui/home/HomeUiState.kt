package dev.ayameio.breathwork.ui.home

import dev.ayameio.breathwork.data.SettingData
import dev.ayameio.breathwork.data.settings


data class HomeUiState(
    val currentSettingSelected: SettingData = settings[0],
    val selectedSettingValue: Float = currentSettingSelected.defaultValue,
)
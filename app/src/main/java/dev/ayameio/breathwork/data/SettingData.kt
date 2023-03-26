package dev.ayameio.breathwork.data

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import dev.ayameio.breathwork.R
import dev.ayameio.breathwork.ui.theme.SkyBlue200
import dev.ayameio.breathwork.ui.theme.SkyBlue500
import dev.ayameio.breathwork.ui.theme.SkyBlue700

data class SettingData(
    @StringRes val title: Int,
    val defaultValue: Float,
    val range: ClosedFloatingPointRange<Float>,
    val colorUnselected: Color,
    val colorSelected: Color,
)

// Tempo of breathing, Fast 1.5f --- 4.0f Slow breathing.
val tempoSetting = SettingData(
    title = R.string.tempo,
    defaultValue = 1.5f,
    colorUnselected = SkyBlue200,
    colorSelected = SkyBlue200,
    range = 1.5f..4f
)
val breathsSetting = SettingData(
    title = R.string.breaths,
    defaultValue = 20f,
    colorUnselected = SkyBlue500,
    colorSelected = SkyBlue500,
    range = 20f..40f
)
val roundsSetting = SettingData(
    title = R.string.rounds,
    defaultValue = 3f,
    colorUnselected = SkyBlue700,
    colorSelected = SkyBlue700,
    range = 3f..8f
)

val settings: List<SettingData> = listOf(tempoSetting, breathsSetting, roundsSetting)
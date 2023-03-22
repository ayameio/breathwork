package dev.ayameio.breathwork.data

import androidx.compose.ui.graphics.Color
import dev.ayameio.breathwork.ui.theme.SkyBlue200
import dev.ayameio.breathwork.ui.theme.SkyBlue500
import dev.ayameio.breathwork.ui.theme.SkyBlue700

data class SettingData(
    val title: String,
    val value: Float,
    val colorUnselected: Color,
    val colorSelected: Color,
    val textColorUnselected: Color,
    val textColorSelected: Color,
    val range: ClosedFloatingPointRange<Float>
)

// Tempo of breathing, Fast 1.5f --- 4.0f Slow breathing.
val tempoSetting = SettingData(
    title = "Tempo",
    value = 1.5f,
    colorUnselected = SkyBlue200,
    colorSelected = SkyBlue200,
    textColorSelected = Color.White,
    textColorUnselected = Color.Black,
    range = 1.5f..4f
)
val breathsSetting = SettingData(
    title = "Breaths",
    value = 20f,
    colorUnselected = SkyBlue500,
    colorSelected = SkyBlue500,
    textColorSelected = Color.White,
    textColorUnselected = Color.Black,
    range = 20f..40f
)
val roundsSetting = SettingData(
    title = "Rounds",
    value = 3f,
    colorUnselected = SkyBlue700,
    colorSelected = SkyBlue700,
    textColorSelected = Color.White,
    textColorUnselected = Color.Black,
    range = 3f..8f
)

val settings: List<SettingData> = listOf(tempoSetting, breathsSetting, roundsSetting)
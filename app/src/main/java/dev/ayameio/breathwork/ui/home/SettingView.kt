package dev.ayameio.breathwork.ui.home


import androidx.annotation.StringRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.ayameio.breathwork.R

@Preview(showBackground = true)
@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = viewModel(),
) {
    Row(
        modifier = modifier.fillMaxWidth(1f).padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            SettingCircle(settingValue = settingsViewModel.tempoSliderValue, settingLabel = R.string.tempo)
            Slider(
                value = settingsViewModel.tempoSliderValue,
                valueRange = 1.5f..4f,
                onValueChange = { settingsViewModel.updateTempo(it) }
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            SettingCircle(settingValue = settingsViewModel.breathsSliderValue, settingLabel = R.string.breaths)
            Slider(
                value = settingsViewModel.breathsSliderValue,
                valueRange = 20f..40f,
                onValueChange = { settingsViewModel.updateBreaths(it) }
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            SettingCircle(settingValue = settingsViewModel.roundsSliderValue, settingLabel = R.string.rounds)
            Slider(
                value = settingsViewModel.roundsSliderValue,
                valueRange = 1f..10f,
                onValueChange = { settingsViewModel.updateRounds(it) }
            )
        }
    }
}

@Composable
fun SettingCircle(
    modifier: Modifier = Modifier,
    settingValue: Float,
    @StringRes settingLabel: Int,
    circleSize: Dp = 60.dp,
    strokeWidth: Dp = 10.dp,
    strokeColor: Color = MaterialTheme.colors.primary
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(circleSize)
                .clip(CircleShape)
        ) {
            Canvas(modifier = Modifier.size(circleSize)) {
                drawCircle(
                    color = strokeColor,
                    style = Stroke(strokeWidth.toPx()),
                )
            }
            Text(modifier = Modifier.align(Alignment.Center), text = "$settingValue")
        }
        Text(stringResource(id = settingLabel))
    }
}
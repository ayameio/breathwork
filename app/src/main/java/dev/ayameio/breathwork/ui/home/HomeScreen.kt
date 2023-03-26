package dev.ayameio.breathwork.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.components.Bubble
import dev.ayameio.breathwork.data.SettingData
import dev.ayameio.breathwork.data.settings
import dev.ayameio.breathwork.ui.theme.BreathworkTheme


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    BreathworkTheme {
        HomeScreen(name = "Adrian")
    }
}

@Preview
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    name: String = ""
) {
    Column(
        modifier = Modifier.padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Welcome back $name!",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(40.dp))
        BreathingSettings(adjusterOn = true, settings = settings)
        Spacer(modifier = Modifier.height(70.dp))
        Bubble()
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier.size(44.dp),
            shape = CircleShape,
            onClick = { /*TODO*/ }
        ) {
            Icon(
                Icons.Filled.PlayArrow,
                contentDescription = "Play",
                modifier = modifier
            )
        }
    }
}

@Composable
fun BreathingSettings(
    modifier: Modifier = Modifier,
    adjusterOn: Boolean = false,
    settings: List<SettingData>
) {
    // We want to know which setting is being selected, and display the setting slider to
    // adjust the settings accordingly.

    val selectedSetting by remember { mutableStateOf(settings[0]) }

    val settingValue = selectedSetting.defaultValue
    val settingRange = selectedSetting.range

    var sliderPosition by remember { mutableStateOf(settingValue) }

    Column(modifier = modifier) {
        Card(modifier = modifier) {
            Column(
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // TODO: Figure out state hoisting
//                SettingsCard(settings = settings, onClick = )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Card(modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
            shape = RoundedCornerShape(15.dp),
            backgroundColor = Color(0xFFE8E8E8)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 40.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Adjust ${selectedSetting.title}")
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Slider(
                        value = sliderPosition,
                        valueRange = settingRange,
                        onValueChange = { sliderPosition = it },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}
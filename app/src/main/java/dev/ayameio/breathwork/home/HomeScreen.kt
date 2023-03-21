package dev.ayameio.breathwork.home

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.components.Bubble
import dev.ayameio.breathwork.components.SettingsCard
import dev.ayameio.breathwork.ui.theme.BreathworkTheme
import dev.ayameio.breathwork.ui.theme.SkyBlue200
import dev.ayameio.breathwork.ui.theme.SkyBlue500
import dev.ayameio.breathwork.ui.theme.SkyBlue700


val tempoSetting = SettingData("Tempo",  1.5f, SkyBlue200)
val breathsSetting = SettingData("Breaths",  20f, SkyBlue500)
val roundsSetting = SettingData("Rounds",  3f, SkyBlue700)

val settings: List<SettingData> = listOf(tempoSetting, breathsSetting, roundsSetting)

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
        BreathingSettings()
        Spacer(modifier = Modifier.height(20.dp))
        AdjusterCard()
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
fun BreathingSettings(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }

    Card(modifier = modifier) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SettingsCard(settings = settings)
        }
    }
}


@Composable
fun Setting(modifier: Modifier = Modifier, title: String, value: Int, color: Color) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .size(size = 60.dp)
            .clip(CircleShape)
            .background(
                color = Color(0xFFE8E8E8)
            )
        ) {
            Canvas(modifier = Modifier
                .size(size = 60.dp)
            ) {
                drawCircle(
                    color = color,
                    style = Stroke(width = 10.dp.toPx())
                )
            }
            Text(
                text = value.toString(),
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.h6
            )
        }
        Text(text = title)
    }
}




data class SettingData(val title: String, val value: Float, val color: Color)

@Composable
fun AdjusterCard(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }

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
            Text(text = "Adjust")
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Add",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Slider(
                    value = sliderPosition,
                    valueRange = 1.5f..4f,
                    onValueChange = { sliderPosition = it },
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = "Add",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}
package dev.ayameio.breathwork.ui.home


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.ayameio.breathwork.R
import dev.ayameio.breathwork.ui.theme.Cherry
import dev.ayameio.breathwork.ui.theme.CherryGradient
import dev.ayameio.breathwork.ui.theme.SkyBlue200
import dev.ayameio.breathwork.ui.theme.SkyGradient
import dev.ayameio.breathwork.ui.theme.Sunny
import dev.ayameio.breathwork.ui.theme.SunnyGradient

@Preview(showBackground = true)
@Composable
fun SettingsView(
    modifier: Modifier = Modifier,
    settingsViewModel: SettingsViewModel = viewModel(),
) {
    Row(
        modifier = modifier
            .fillMaxWidth(1f)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = stringResource(id = R.string.tempo))
            SettingArc(value = settingsViewModel.tempoSliderValue, minValue = 1.5f, maxValue = 4f, color = SkyBlue200, gradient = SkyGradient)
            Slider(
                value = settingsViewModel.tempoSliderValue,
                valueRange = 1.5f..4f,
                onValueChange = { settingsViewModel.updateTempo(it) },
                steps = 5
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = stringResource(id = R.string.breaths))
            SettingArc(value = settingsViewModel.breathsSliderValue, minValue = 20f, maxValue = 40f, color = Cherry, gradient = CherryGradient)
            Slider(
                value = settingsViewModel.breathsSliderValue,
                valueRange = 20f..40f,
                onValueChange = { settingsViewModel.updateBreaths(it) },
                steps = 19
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = stringResource(id = R.string.rounds))
            SettingArc(value = settingsViewModel.roundsSliderValue, minValue = 1f, maxValue = 10f, color = Sunny, gradient = SunnyGradient)
            Slider(
                value = settingsViewModel.roundsSliderValue,
                valueRange = 1f..10f,
                onValueChange = { settingsViewModel.updateRounds(it) },
                steps = 9
            )
        }
    }
}

fun DrawScope.drawArcs(
    progress: Float,
    maxValue: Float,
    strokeWidth: Dp,
    color: Color,
    gradient: Brush
) {
    val startAngle = 270 - maxValue / 2
    val sweepAngle = maxValue * progress

    fun drawStrokeBackground() {
        drawArc(
            color = Color(0xFFE8E8E8),
            startAngle = startAngle,
            sweepAngle = 225f,
            useCenter = false,
            style = Stroke(width = 30f, cap = StrokeCap.Round)
        )
    }

    fun drawBlur() {
        for (i in 0..20) {
            drawArc(
                color = color.copy(alpha = i / 900f),
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = 10f + (20 - i) * 3f, cap = StrokeCap.Round)
            )
        }
    }

    fun drawStroke() {
        drawArc(
            color = color,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 25f, cap = StrokeCap.Round)
        )
    }

    fun drawGradient() {
        drawArc(
            brush = gradient,
            startAngle = startAngle,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = Stroke(width = 10f, cap = StrokeCap.Round)
        )
    }

    drawStrokeBackground()
    drawBlur()
    drawStroke()
    drawGradient()
}

@Composable
fun SettingArcIndicator(
    value: Float,
    angle: Float,
    circleSize: Dp = 60.dp,
    strokeWidth: Dp = 10.dp,
    color: Color = SkyBlue200,
    gradient: Brush = SkyGradient
) {
    Canvas(
        modifier = Modifier
            .size(circleSize)
    ) {
        drawArcs(value, angle, strokeWidth = strokeWidth, color = color, gradient = gradient)
    }
}

@Composable
fun SettingArc(
    value: Float = 1f,
    maxValue: Float = 2f,
    minValue: Float = 0f,
    color: Color = MaterialTheme.colors.primary,
    gradient: Brush = Brush.radialGradient(colors = listOf(
        MaterialTheme.colors.primary,
        MaterialTheme.colors.primary.copy(alpha = 0.5f)
    ))
) {
    var normalized = (value - minValue) / (maxValue - minValue)
    Box(
        modifier = Modifier.size(70.dp),
        contentAlignment = Alignment.BottomCenter,
    ) {
        SettingArcIndicator(
            normalized,
            240f,
            color = color,
            gradient = gradient
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "${value.toInt()}",
            style = TextStyle(fontWeight = FontWeight.Black, fontSize = 18.sp)
        )
    }
}
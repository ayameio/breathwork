package dev.ayameio.breathwork.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.ui.theme.SkyGradient

@Composable
fun Bubble(modifier: Modifier = Modifier, gradient: Brush = SkyGradient) {
    Canvas(modifier = Modifier
        .size(size = 160.dp)
    ) {
        drawCircle(
            brush = gradient,
            radius = 80.dp.toPx()
        )
        drawCircle(
            color = Color(0xFFCDEDFF),
            radius = 80.dp.toPx(),
            style = Stroke(width = 4.dp.toPx())
        )
    }
}
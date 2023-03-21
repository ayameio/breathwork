package dev.ayameio.breathwork.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp


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
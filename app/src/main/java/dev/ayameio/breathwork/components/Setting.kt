package dev.ayameio.breathwork.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.data.SettingData


@Composable
fun Setting(
    modifier: Modifier = Modifier,
    settingData: SettingData,
    textColorUnselected: Color,
    textColorSelected: Color,
    size: Dp = 60.dp,
    textStyle: TextStyle =  MaterialTheme.typography.h6,
    strokeWidth: Dp = 10.dp,
    selectable: Boolean = true,
    onClick: () -> Unit
) {
    val isSelected by remember { mutableStateOf(false)}

    Column(
        modifier = Modifier.clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .size(size = size)
            .clip(CircleShape)
            .background(
                color = Color(0xFFE8E8E8)
            )
        ) {
            Canvas(modifier = Modifier.size(size = size)
            ) {
                drawCircle(
                    color = settingData.colorUnselected,
                    style = Stroke(width = strokeWidth.toPx())
                )
            }
            Text(
                text = settingData.defaultValue.toString(),
                modifier = Modifier.align(Alignment.Center),
                style = textStyle
            )
        }
        Text(text = stringResource(id = settingData.title))
    }
}
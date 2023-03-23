package dev.ayameio.breathwork.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Use this component to display retention times in recorded sessions.
@Composable
fun RetentionTimeCircle(
    modifier: Modifier = Modifier,
    time: Float
) {
    Box(modifier = Modifier
        .size(size = 40.dp)
        .clip(CircleShape)
        .background(
            color = Color(0x803EB9FF)
        )
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "$time"
        )
    }
}
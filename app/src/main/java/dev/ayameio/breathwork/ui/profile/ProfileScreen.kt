package dev.ayameio.breathwork.ui.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun ProfileScreen() {
    Box(modifier = Modifier, contentAlignment = Alignment.Center) {
        Text(text = "Profile Screen", textAlign = TextAlign.Center)
    }
}
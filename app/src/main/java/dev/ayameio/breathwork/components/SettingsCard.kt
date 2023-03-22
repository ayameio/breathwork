package dev.ayameio.breathwork.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.data.SettingData

@Composable
fun SettingsCard(
    modifier: Modifier = Modifier,
    settings: List<SettingData>,
    selectable: Boolean = true,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(20.dp),
        backgroundColor = Color(0xFFE8E8E8)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 40.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Settings")
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                settings.forEach { setting ->
                    Setting(
                        settingData = setting,
                        selectable = selectable,
                        onClick = onClick
                    )
                }
            }
        }
    }
}
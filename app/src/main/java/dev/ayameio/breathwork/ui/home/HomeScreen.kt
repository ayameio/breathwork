package dev.ayameio.breathwork.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.R
import dev.ayameio.breathwork.components.Bubble
import dev.ayameio.breathwork.ui.theme.BreathworkTheme

enum class HomePaths(@StringRes val title: Int) {
    Home (title = R.string.home),
    Profile (title = R.string.profile),
    Session (title = R.string.breathwork_session)
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userName: String = "",
) {
    Column(
        modifier = modifier.padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Welcome back $userName!",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(40.dp))
        SettingsView()
        Spacer(modifier = Modifier.height(70.dp))
        Bubble()
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            modifier = Modifier.width(140.dp),
            shape = RoundedCornerShape(20.dp),
            onClick = { /*TODO: Navigate to session screen*/ }
        ) {
            Text(text = "Start Session")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    BreathworkTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    BreathworkTheme {
        SettingsView()
    }
}


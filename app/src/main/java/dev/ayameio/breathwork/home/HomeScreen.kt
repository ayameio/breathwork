package dev.ayameio.breathwork.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshoe.kalendar.Kalendar
import com.himanshoe.kalendar.model.KalendarType
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
        modifier = Modifier.padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome $name!",
            style = MaterialTheme.typography.h3
        )
        Button(
            modifier = modifier,
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(horizontal = 30.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Start Session",
            )
        }
    }
}
package dev.ayameio.breathwork.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.ui.theme.BreathworkTheme


@Preview(showSystemUi = true)
@Composable
fun OnboardPreview() {
    BreathworkTheme {
        OnboardScreen(
        )
    }
}

@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
) {
    var text: String by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = modifier,
            text = "Welcome!",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = modifier,
                shape = CircleShape,
                label = {
                    Text(text = "Name")
                },
                value = text,
                onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                )
            )
            OutlinedTextField(
                modifier = modifier,
                shape = CircleShape,
                label = {
                    Text(text = "Email")
                },
                value = text,
                onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                )
            )
            Button(
                modifier = Modifier
                    .padding(top = 36.dp)
                    .height(TextFieldDefaults.MinHeight)
                    .width(TextFieldDefaults.MinWidth),
                onClick = { /* ... */ },
                // Uses ButtonDefaults.ContentPadding by default

                shape = CircleShape,
            ) {
                // Inner content including an icon and a text label
                Text("Join")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = "Join",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            }
        }
    }
}
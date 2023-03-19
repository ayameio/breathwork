package dev.ayameio.breathwork.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
    BreathworkTheme(darkTheme = false) {
        OnboardScreen(
            name = null,
            email = null,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
    name: String?,
    email: String?
) {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = modifier,
            text = "Welcome!",
            style = MaterialTheme.typography.h3
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = modifier,
            text = "What's your name?",
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(modifier = Modifier.height(48.dp)) {
            OutlinedTextField(
                modifier = modifier,
                value = text,
                onValueChange = { text = it },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = MaterialTheme.colors.background
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                modifier = Modifier.fillMaxHeight().width(48.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary,
                    contentColor = Color.White),
                contentPadding = PaddingValues(0.dp),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = modifier,
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next",
                )
            }
        }
    }
}

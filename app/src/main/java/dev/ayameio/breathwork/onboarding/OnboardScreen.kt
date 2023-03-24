package dev.ayameio.breathwork.onboarding

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.ayameio.breathwork.R
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
    var nameValue: String by remember { mutableStateOf("") }
    var emailValue: String by remember { mutableStateOf("") }

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
            EditField(
                value = nameValue,
                onValueChange = { nameValue = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
                id = R.string.name
            )
            EditField(
                value = emailValue,
                onValueChange = { emailValue = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                id = R.string.email
            )
            JoinButton()
        }
    }
}

@Composable
fun EditField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    @StringRes id: Int,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        label = {
            Text(text = stringResource(id = id))
        },
        shape = CircleShape,
    )
}

@Composable
fun JoinButton() {
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
        Text(text = stringResource(id = R.string.join_for_free))
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Icon(
            Icons.Filled.ArrowForward,
            contentDescription = "Join",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
    }
}
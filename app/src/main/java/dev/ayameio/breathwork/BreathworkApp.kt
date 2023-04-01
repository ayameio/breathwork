package dev.ayameio.breathwork

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.ayameio.breathwork.ui.OnboardScreen
import dev.ayameio.breathwork.ui.home.HomeScreen

enum class BreathworkScreen(@StringRes val title: Int) {
    Onboard (title = R.string.onboard),
    Home (title = R.string.home),
}

class BreathworkViewModel: ViewModel() {
    val passedOnboarding: Boolean = false
}

@Composable
fun BreathworkApp(
    viewModel: BreathworkViewModel = viewModel(),
) {
    val navController = rememberNavController()
    val passedOnboarding = viewModel.passedOnboarding
    val startingRoute = if (passedOnboarding) BreathworkScreen.Home.title else BreathworkScreen.Onboard.title
    NavHost(
        navController = navController,
        startDestination = stringResource(id = startingRoute)
    ) {
        composable("Onboard") { OnboardScreen() }
        composable("Home") { HomeScreen() }
    }
}
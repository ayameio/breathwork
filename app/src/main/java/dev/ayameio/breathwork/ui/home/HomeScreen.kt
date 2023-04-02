package dev.ayameio.breathwork.ui.home

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.ayameio.breathwork.R
import dev.ayameio.breathwork.components.Bubble
import dev.ayameio.breathwork.ui.profile.ProfileScreen
import dev.ayameio.breathwork.ui.theme.BreathworkTheme
import dev.ayameio.breathwork.ui.theme.SkyBlue200

sealed class HomeNavigationScreen(val route: String, @StringRes val resourceId: Int) {
    object Home: HomeNavigationScreen ("home", resourceId = R.string.home)
    object Profile: HomeNavigationScreen ("profile",  resourceId = R.string.profile)
    object Session: HomeNavigationScreen ("session", resourceId = R.string.breathwork_session)
}

val items = listOf(
    HomeNavigationScreen.Home,
    HomeNavigationScreen.Profile,
)

@Composable
fun NavigationBar(
    modifier: Modifier,
    navController: NavHostController,
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        elevation = 5.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                icon = { Icons.Filled.AccountBox },
                label = { Text(stringResource(item.resourceId)) },
                selectedContentColor = SkyBlue200,
                unselectedContentColor = Color.Gray,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }

            )
        }
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userName: String = "Adrian",
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar(modifier = modifier, navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = HomeNavigationScreen.Home.route,
        ) {
            composable(HomeNavigationScreen.Home.route) { HomeScreen()}
            composable(HomeNavigationScreen.Profile.route) { ProfileScreen() }
        }
    }
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
package kevinjoramos.androidcodingchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kevinjoramos.androidcodingchallenge.ui.screens.PrimaryScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppDestination.PrimaryScreen.route,
    ) {
        composable(AppDestination.PrimaryScreen.route) { PrimaryScreen() }
    }
}
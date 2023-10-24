package kevinjoramos.androidapptemplate.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kevinjoramos.androidapptemplate.ui.screens.TemplateScreen

@Composable
fun TemplateNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppDestination.TemplateScreen.route,
    ) {
        composable(AppDestination.TemplateScreen.route) { TemplateScreen() }
    }
}
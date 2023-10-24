package kevinjoramos.androidcodingchallenge.ui.navigation

sealed class AppDestination(val route: String) {
    data object PrimaryScreen : AppDestination("primary-screen")
    // ...add routes to other screens here.
}

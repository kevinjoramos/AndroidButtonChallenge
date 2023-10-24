package kevinjoramos.androidapptemplate.ui.navigation

sealed class AppDestination(val route: String) {
    object TemplateScreen : AppDestination("template-screen")
    // ...add routes to other screens here.
}

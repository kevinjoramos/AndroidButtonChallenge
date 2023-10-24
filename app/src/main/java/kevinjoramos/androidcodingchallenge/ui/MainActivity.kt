package kevinjoramos.androidcodingchallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import kevinjoramos.androidcodingchallenge.ui.navigation.AppNavigation
import kevinjoramos.androidcodingchallenge.ui.theme.AndroidCodingChallengeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            AndroidCodingChallengeTheme {
                // A surface container using the 'background' color from the theme
                WindowCompat.setDecorFitsSystemWindows(
                    window,
                    false
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}


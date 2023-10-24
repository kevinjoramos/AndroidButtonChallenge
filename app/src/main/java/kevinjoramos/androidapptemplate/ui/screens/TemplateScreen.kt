package kevinjoramos.androidapptemplate.ui.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kevinjoramos.androidapptemplate.ui.state.TemplateUiState
import kevinjoramos.androidapptemplate.ui.viewmodel.TemplateViewModel

@Composable
fun TemplateScreen(
    viewModel: TemplateViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    viewModel.fetchMessage()

    when (uiState){
        is TemplateUiState.Loading -> CircularProgressIndicator()
        is TemplateUiState.Error -> Greeting((uiState as TemplateUiState.Error).message ?: "There was an unexpected error.")
        else -> Greeting(message = (uiState as TemplateUiState.Success).message)
    }
}

@Composable
fun Greeting(message: String) {
    Text(text = message)
}
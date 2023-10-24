package kevinjoramos.androidcodingchallenge.ui.screens

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kevinjoramos.androidcodingchallenge.ui.state.PrimaryUiState
import kevinjoramos.androidcodingchallenge.ui.viewmodel.PrimaryViewModel

@Composable
fun PrimaryScreen(
    viewModel: PrimaryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    viewModel.fetchMessage()

    when (uiState){
        is PrimaryUiState.Loading -> CircularProgressIndicator()
        is PrimaryUiState.Error -> Greeting((uiState as PrimaryUiState.Error).message ?: "There was an unexpected error.")
        else -> Greeting(message = (uiState as PrimaryUiState.Success).message)
    }
}

@Composable
fun Greeting(message: String) {
    Text(text = message)
}
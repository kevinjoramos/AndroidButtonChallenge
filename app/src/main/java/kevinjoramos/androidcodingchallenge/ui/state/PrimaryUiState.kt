package kevinjoramos.androidcodingchallenge.ui.state

import java.io.IOException

sealed interface PrimaryUiState {

    data object Initial : PrimaryUiState

    data object Loading : PrimaryUiState

    data class Success(
        val stateText: String
    ): PrimaryUiState

    data class Error(
        val exception: IOException?,
        val stateText: String
    ) : PrimaryUiState
}
package kevinjoramos.androidcodingchallenge.ui.state

sealed interface PrimaryUiState {
    data object Loading : PrimaryUiState

    data class Success(
        val message: String
    ): PrimaryUiState

    data class Error(
        val exception: Exception,
        val message: String?
    ) : PrimaryUiState
}
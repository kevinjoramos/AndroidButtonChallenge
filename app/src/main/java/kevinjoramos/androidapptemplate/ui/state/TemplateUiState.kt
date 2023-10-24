package kevinjoramos.androidapptemplate.ui.state

sealed interface TemplateUiState {
    data object Loading : TemplateUiState

    data class Success(
        val message: String
    ): TemplateUiState

    data class Error(
        val exception: Exception,
        val message: String?
    ) : TemplateUiState
}
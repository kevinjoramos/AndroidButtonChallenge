package kevinjoramos.androidapptemplate.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevinjoramos.androidapptemplate.data.repository.TemplateRepository
import kevinjoramos.androidapptemplate.ui.state.TemplateUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val repository: TemplateRepository
    // other viewmodel dependencies...
) : ViewModel() {

    private val _uiState: MutableStateFlow<TemplateUiState> = MutableStateFlow(TemplateUiState.Loading)
    val uiState: StateFlow<TemplateUiState> = _uiState.asStateFlow()

    private var fetchJob: Job? = null

    fun fetchMessage() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                val message = repository.getGreeting()
                _uiState.update {
                    when (it) {
                        is TemplateUiState.Success -> it.copy(message = message)
                        else -> TemplateUiState.Success(message)
                    }
                }
            } catch (ioe: IOException) {
                _uiState.update {
                    TemplateUiState.Error(ioe, ioe.message)
                }
            }
        }
    }


}
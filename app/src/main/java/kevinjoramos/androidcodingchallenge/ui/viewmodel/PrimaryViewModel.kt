package kevinjoramos.androidcodingchallenge.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevinjoramos.androidcodingchallenge.data.network.MockedNetworkResponse
import kevinjoramos.androidcodingchallenge.data.repository.PrimaryRepository
import kevinjoramos.androidcodingchallenge.ui.state.PrimaryUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class PrimaryViewModel @Inject constructor(
    private val repository: PrimaryRepository
    // other viewmodel dependencies...
) : ViewModel() {

    private val _uiState: MutableStateFlow<PrimaryUiState> = MutableStateFlow(PrimaryUiState.Initial)
    val uiState: StateFlow<PrimaryUiState> = _uiState.asStateFlow()

    private var fetchJob: Job? = null

    fun makeAsyncRequest() {
        fetchJob?.cancel()

        _uiState.value = PrimaryUiState.Loading
        fetchJob = viewModelScope.launch {
            try {
                val response = repository.mockedResponse()

                _uiState.update {
                    when (response) {
                        is MockedNetworkResponse.Success -> {
                            val data = response.data as String
                            PrimaryUiState.Success(data)
                        }
                        else -> {
                            val errorMessage = response.error as String
                            PrimaryUiState.Error(null, errorMessage)
                        }
                    }
                }
            } catch (ioe: IOException) {
                _uiState.update {
                    PrimaryUiState.Error(ioe, "Error")
                }
            }
        }
    }


}
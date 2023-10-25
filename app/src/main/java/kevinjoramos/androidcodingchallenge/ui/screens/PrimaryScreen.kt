package kevinjoramos.androidcodingchallenge.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kevinjoramos.androidcodingchallenge.ui.state.PrimaryUiState
import kevinjoramos.androidcodingchallenge.ui.theme.AndroidCodingChallengeTheme
import kevinjoramos.androidcodingchallenge.ui.viewmodel.PrimaryViewModel

@Composable
fun PrimaryScreen(
    viewModel: PrimaryViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    val stateMessage = when (uiState){
        is PrimaryUiState.Initial -> "Pending"
        is PrimaryUiState.Loading -> "Loading"
        is PrimaryUiState.Error -> (uiState as PrimaryUiState.Error).stateText
        is PrimaryUiState.Success -> (uiState as PrimaryUiState.Success).stateText
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            //.background(backgroundColor)
    ) {

        Button(
            onClick = { viewModel.makeAsyncRequest() },
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = when (uiState) {
                    is PrimaryUiState.Loading -> Color.Gray
                    else -> MaterialTheme.colorScheme.primary
                }
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = when (uiState) {
                        is PrimaryUiState.Loading -> "Loading"
                        else -> "Login"
                    },
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp)
                )

                if (uiState is PrimaryUiState.Loading) {
                    Spacer(modifier = Modifier.width(20.dp))

                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }


        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "State = $stateMessage",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = when (uiState) {
                is PrimaryUiState.Success -> Color.Green
                is PrimaryUiState.Error -> Color.Red
                else -> MaterialTheme.colorScheme.onBackground
            }
        )
    }
}
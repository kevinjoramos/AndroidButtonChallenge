package kevinjoramos.androidcodingchallenge.data.repository

import kevinjoramos.androidcodingchallenge.data.network.MockedNetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PrimaryRepository @Inject constructor(
    // data source classes here...
) {
    suspend fun mockedResponse(): MockedNetworkResponse<String> =
        withContext(Dispatchers.IO) {
            delay(2000)

            return@withContext when((0..1).random()) {
                0 -> MockedNetworkResponse.Failure("Error")
                else -> MockedNetworkResponse.Success("Success(Body=Response)")
            }
        }
}
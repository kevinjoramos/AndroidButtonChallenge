package kevinjoramos.androidcodingchallenge.data.network

sealed class MockedNetworkResponse<T>(
    val data: T? = null,
    val error: String? = null
) {
    class Success<T> (data: T) : MockedNetworkResponse<T>(data = data)
    class Failure<T> (error: String) : MockedNetworkResponse<T>(error = error)
}

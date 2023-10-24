package kevinjoramos.androidcodingchallenge.data.repository

import javax.inject.Inject

class PrimaryRepository @Inject constructor(
    // data source classes here...
) {
    fun getGreeting(): String = "Hello World!"

}
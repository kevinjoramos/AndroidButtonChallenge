package kevinjoramos.androidapptemplate.data.repository

import javax.inject.Inject

class TemplateRepository @Inject constructor(
    // data source classes here...
) {
    fun getGreeting(): String = "Hello World!"

}
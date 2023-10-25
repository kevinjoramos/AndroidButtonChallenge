<!-- ABOUT THE PROJECT -->
## About The Project

In this project, I was tasked with creating a button that would generate a request that would receive a mocked response.

While I'm aware this project is very simple and can be completed with a single file, I decided to treat this as an enterprise level app in order to show my current knowledge of app architecture.
I've done my best here to follow the recommended app architecture from Google, which includes building a ui layer and a data layer with the MVVM model.

## Data Layer

Usually our repository class would have dependencies that would be in charge of the heavy lifting for making requests to a data source. However since we are returning a mocked response, it didn't make sense to this here.
![Repository lack of dependencies](images/img.png)

Using Kotlin's sealed classes feature, I can handle both a successful and unsuccessful responses from the data source.
![Network Response Sealed classes](images/img_1.png)

This member function is used by the repository to mock our response when called. Here we use withContext() in order execute this function off the main thread.
![Mock function](images/img_2.png)

## UI Layer

Our view-model class receives a reference to a repository instance. We also use a stateflow to wrap our UI state object.
![Viewmodel](/images/img_3.png)

Here is our data object for representing the ui state. Here we also make use of sealed classes in communicate what our UI should be doing.
![Ui State](/images/img_4.png)

Next, you will see that the following member function of the view-model is used to call the mock function from the repository, and update the ui state accordingly with the results.
![Try Catch Block](/images/img_5.png)


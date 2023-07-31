# MVVMHiltRecipeApp

A sample android app that shows how to use ViewModels and Room together with Coroutines & Hilt, in Kotlin.

## Main Features
- Kotlin
- MVVM
- Hilt
- Coroutines
- LiveData
- Retrofit2
- Room
- Jetpack Navogation Component
- Single Activity 
- Add Themes
- Glide

## Communication between layers in project
 
1. UI calls method from ViewModel.
2. ViewModel executes Use case.
3. Use case combines data from Room and server.
4. Each Repository returns data from a Data Source.


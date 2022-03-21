package com.example.exampletask


enum class Screens{
    RECIPE
}
interface AppNavigator {
    //Navigate to a given screen.
    fun navigateTo(screens: Screens)
}
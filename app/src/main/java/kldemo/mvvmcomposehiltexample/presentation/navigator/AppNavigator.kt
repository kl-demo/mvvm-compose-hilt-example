package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController

interface AppNavigator {
    fun setController(controller: NavHostController)
    fun startScreen(): Screen
    fun navigateTo(screen: Screen)
    fun back(): Boolean
    fun backToStart(): Boolean
}
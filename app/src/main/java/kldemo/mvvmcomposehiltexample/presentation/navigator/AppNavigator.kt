package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Counter : Screen()
}

interface AppNavigator {
    fun setController(controller: NavHostController)
    fun release()
    fun startScreen(): Screen
    fun navigateTo(screen: Screen)
    fun navigateBack(): Boolean
}
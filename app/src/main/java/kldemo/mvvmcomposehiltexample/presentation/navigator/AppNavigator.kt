package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ProgrammingLanguages : Screen()

    @Serializable
    data class ProgrammingLanguageDetails(val name: String) : Screen()
}

interface AppNavigator {
    fun setController(controller: NavHostController)
    fun dispose()
    fun startScreen(): Screen
    fun navigateTo(screen: Screen)
    fun navigateBack(): Boolean
}
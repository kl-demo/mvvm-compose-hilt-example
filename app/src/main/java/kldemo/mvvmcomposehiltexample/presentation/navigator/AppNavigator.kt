package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController
import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ProgrammingLanguages : Screen()

    @Serializable
    data class ProgrammingLanguageDetails(val langName: String) : Screen()
}

interface AppNavigator {
    fun setController(controller: NavHostController)
    fun startScreen(): Screen
    fun navigateTo(screen: Screen)
    fun navigateBack(): Boolean
}
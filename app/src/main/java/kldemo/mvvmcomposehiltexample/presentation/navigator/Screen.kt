package kldemo.mvvmcomposehiltexample.presentation.navigator

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object ProgrammingLanguages : Screen()

    @Serializable
    data class ProgrammingLanguageDetails(val langName: String) : Screen()
}
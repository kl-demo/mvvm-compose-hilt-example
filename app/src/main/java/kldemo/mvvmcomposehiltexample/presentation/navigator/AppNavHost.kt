package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposehiltexample.presentation.lang_details.ProgrammingLanguageDetailsScreen
import kldemo.mvvmcomposehiltexample.presentation.langs.ProgrammingLanguagesScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    startScreen: Screen
) {
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {
        composable<Screen.ProgrammingLanguages> {
            ProgrammingLanguagesScreen()
        }
        composable<Screen.ProgrammingLanguageDetails> {
            ProgrammingLanguageDetailsScreen()
        }
    }
}

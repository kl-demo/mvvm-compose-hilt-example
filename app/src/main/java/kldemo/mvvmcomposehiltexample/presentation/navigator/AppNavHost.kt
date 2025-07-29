package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposehiltexample.presentation.lang_details.ProgrammingLanguageDetailsScreen
import kldemo.mvvmcomposehiltexample.presentation.lang_details.ProgrammingLanguageDetailsViewModel
import kldemo.mvvmcomposehiltexample.presentation.langs.ProgrammingLanguagesScreen
import kldemo.mvvmcomposehiltexample.presentation.langs.ProgrammingLanguagesViewModel

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
            ProgrammingLanguagesScreen(hiltViewModel<ProgrammingLanguagesViewModel>())
        }
        composable<Screen.ProgrammingLanguageDetails> {
            ProgrammingLanguageDetailsScreen(hiltViewModel<ProgrammingLanguageDetailsViewModel>())
        }
    }
}

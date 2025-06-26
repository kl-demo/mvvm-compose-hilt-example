package kldemo.mvvmcomposehiltexample.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavHost
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposehiltexample.presentation.theme.AppTheme

@Composable
fun App(appNavigator: AppNavigator) {
    AppTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val navController: NavHostController = rememberNavController()
            appNavigator.setController(navController)
            AppNavHost(
                navController,
                appNavigator.startScreen()
            )
        }
    }
}
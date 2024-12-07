package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kldemo.mvvmcomposehiltexample.presentation.counter.CounterScreen
import kldemo.mvvmcomposehiltexample.presentation.counter.CounterViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startScreen: Screen
) {
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {
        composable<Screen.Counter> {
            CounterScreen(
                modifier,
                hiltViewModel<CounterViewModel>()
            )
        }
    }
}

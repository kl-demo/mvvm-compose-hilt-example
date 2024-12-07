package kldemo.mvvmcomposehiltexample.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavHost
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposehiltexample.presentation.theme.MvvmComposeHiltExampleTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MvvmComposeHiltExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController: NavHostController = rememberNavController()
                    appNavigator.setController(navController)
                    AppNavHost(
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        navController,
                        appNavigator.startScreen()
                    )
                }
            }
        }
    }

    override fun onDestroy() {
        appNavigator.release()
        super.onDestroy()
    }
}

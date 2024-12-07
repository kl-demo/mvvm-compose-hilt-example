package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {
    private var navHostController: NavHostController? = null

    override fun setController(controller: NavHostController) {
        navHostController = controller
    }

    override fun release() {
        navHostController = null
    }

    override fun startScreen(): Screen = Screen.Counter

    override fun navigateTo(screen: Screen) {
        when (screen) {
            Screen.Counter -> navHostController?.navigate(Screen.Counter)
        }
    }

    override fun navigateBack(): Boolean {
        navHostController?.run {
            return popBackStack()
        }
        return false
    }
}
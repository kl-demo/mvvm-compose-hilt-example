package kldemo.mvvmcomposehiltexample.presentation.navigator

import androidx.navigation.NavHostController
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {
    private var navHostController: NavHostController? = null

    override fun setController(controller: NavHostController) {
        navHostController = controller
    }

    override fun startScreen(): Screen = Screen.ProgrammingLanguages

    override fun navigateTo(screen: Screen) {
        navHostController?.navigate(screen)
    }

    override fun back(): Boolean {
        navHostController?.run {
            return popBackStack()
        }
        return false
    }

    override fun backToStart(): Boolean {
        navHostController?.run {
            return popBackStack(
                route = startScreen(),
                inclusive = false,
                saveState = false
            )
        }
        return false
    }
}
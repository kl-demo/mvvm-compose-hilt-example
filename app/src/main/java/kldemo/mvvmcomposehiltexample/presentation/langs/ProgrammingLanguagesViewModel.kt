package kldemo.mvvmcomposehiltexample.presentation.langs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kldemo.mvvmcomposehiltexample.domain.langs.ProgrammingLanguagesManager
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposehiltexample.presentation.navigator.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgrammingLanguagesViewModel @Inject constructor(
    private val programmingLanguagesManager: ProgrammingLanguagesManager,
    private val appNavigator: AppNavigator
) :
    ViewModel() {

    private val programmingLanguagesViewStateMutable =
        MutableStateFlow(
            ProgrammingLanguagesViewState(
                programmingLanguages = emptyList(),
                isLoading = true
            )
        )
    val programmingLanguagesViewState = programmingLanguagesViewStateMutable.asStateFlow()

    init {
        getProgrammingLanguages()
    }

    fun detailsClicked(name: String) {
        appNavigator.navigateTo(Screen.ProgrammingLanguageDetails(name))
    }

    private fun getProgrammingLanguages() {
        viewModelScope.launch(Dispatchers.IO) {
            val programmingLanguages = programmingLanguagesManager.getProgrammingLanguages()
            programmingLanguagesViewStateMutable.update { currentState ->
                currentState.copy(
                    programmingLanguages = programmingLanguages,
                    isLoading = false
                )
            }
        }
    }
}
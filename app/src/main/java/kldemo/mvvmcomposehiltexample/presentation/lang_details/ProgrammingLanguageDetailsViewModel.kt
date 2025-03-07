package kldemo.mvvmcomposehiltexample.presentation.lang_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails
import kldemo.mvvmcomposehiltexample.domain.lang_details.ProgrammingLanguageDetailsManager
import kldemo.mvvmcomposehiltexample.presentation.navigator.AppNavigator
import kldemo.mvvmcomposehiltexample.presentation.navigator.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProgrammingLanguageDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val programmingLanguageDetailsManager: ProgrammingLanguageDetailsManager,
    private val appNavigator: AppNavigator
) :
    ViewModel() {

    private val route = savedStateHandle.toRoute<Screen.ProgrammingLanguageDetails>()
    private val programmingLanguageDetailsViewStateMutable =
        MutableStateFlow(getInitProgrammingLanguageDetailsViewState())
    val programmingLanguageDetailsViewState =
        programmingLanguageDetailsViewStateMutable.asStateFlow()

    init {
        programmingLanguageDetailsViewStateMutable.update { currentState ->
            currentState.copy(
                langName = route.name
            )
        }
        getProgrammingLanguageDetails(route.name)

    }

    fun backClicked() {
        appNavigator.navigateBack()
    }

    private fun getProgrammingLanguageDetails(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val programmingLanguageDetails =
                programmingLanguageDetailsManager.getProgrammingLanguageDetails(name)
            programmingLanguageDetailsViewStateMutable.update { currentState ->
                currentState.copy(
                    programmingLanguageDetails = programmingLanguageDetails,
                    isLoading = false
                )
            }
        }
    }

    private fun getInitProgrammingLanguageDetailsViewState() = ProgrammingLanguageDetailsViewState(
        langName = "",
        programmingLanguageDetails = ProgrammingLanguageDetails("", ""),
        isLoading = true
    )
}
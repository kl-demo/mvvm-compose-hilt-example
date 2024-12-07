package kldemo.mvvmcomposehiltexample.presentation.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kldemo.mvvmcomposehiltexample.domain.counter.CounterManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CounterViewModel @Inject constructor(
    private val counterManager: CounterManager
) :
    ViewModel() {

    private val counterViewStateMutable: MutableLiveData<CounterViewState> =
        MutableLiveData<CounterViewState>()
    val counterViewState: LiveData<CounterViewState> = counterViewStateMutable

    init {
        counterViewStateMutable.value = getInitCounterViewState()
        viewModelScope.launch(Dispatchers.IO) {
            getNumberOfClicks()
        }
    }

    fun incrementBtnClicked() {
        counterViewStateMutable.value?.let { counterViewState ->
            counterViewStateMutable.value = counterViewState.copy(isLoading = true)
        } ?: run {
            counterViewStateMutable.value = getInitCounterViewState()
        }

        viewModelScope.launch(Dispatchers.IO) {
            counterManager.incrementNumberOfClicks()
            getNumberOfClicks()
        }
    }

    private suspend fun getNumberOfClicks() {
        delay(1000)//emulate network latency
        val numberOfClicks = counterManager.getNumberOfClicks()
        withContext(Dispatchers.Main) {
            counterViewStateMutable.value?.let { counterViewState ->
                counterViewStateMutable.value = counterViewState.copy(
                    numberOfClicks = numberOfClicks,
                    isLoading = false
                )
            } ?: run {
                counterViewStateMutable.value = getInitCounterViewState().copy(
                    numberOfClicks = numberOfClicks,
                    isLoading = false
                )
            }
        }
    }

    private fun getInitCounterViewState() = CounterViewState(
        numberOfClicks = 0,
        isLoading = true
    )
}
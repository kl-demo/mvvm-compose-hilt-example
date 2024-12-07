package kldemo.mvvmcomposehiltexample.presentation.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kldemo.mvvmcomposehiltexample.R

@Composable
fun CounterScreen(
    modifier: Modifier,
    counterViewModel: CounterViewModel
) {
    val counterViewState = counterViewModel.counterViewState.observeAsState().value
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.number_of_clicks),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        if (counterViewState?.isLoading == false) {
            Text(
                "${counterViewState.numberOfClicks}",
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        if (counterViewState?.isLoading == true) {
            CircularProgressIndicator(modifier = Modifier.padding(bottom = 8.dp))
        }
        Button(
            enabled = counterViewState?.isLoading == false,
            onClick = { counterViewModel.incrementBtnClicked() }) {
            Text(stringResource(R.string.increment))
        }
    }
}

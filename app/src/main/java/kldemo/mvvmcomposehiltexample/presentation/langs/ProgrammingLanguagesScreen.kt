package kldemo.mvvmcomposehiltexample.presentation.langs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kldemo.mvvmcomposehiltexample.R
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmcomposehiltexample.presentation.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProgrammingLanguagesScreen(programmingLanguagesViewModel: ProgrammingLanguagesViewModel) {

    val programmingLanguagesViewState =
        programmingLanguagesViewModel.programmingLanguagesViewState.collectAsStateWithLifecycle().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(stringResource(R.string.programming_languages))
                }
            )
        }) { innerPadding ->
        Content(
            programmingLanguagesViewModel,
            programmingLanguagesViewState,
            innerPadding
        )
    }
}

@Composable
private fun Content(
    programmingLanguagesViewModel: ProgrammingLanguagesViewModel,
    programmingLanguagesViewState: ProgrammingLanguagesViewState,
    innerPadding: PaddingValues

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        if (programmingLanguagesViewState.isLoading) {
            Loading()
        } else {
            Loaded(
                programmingLanguagesViewState.programmingLanguages,
                programmingLanguagesViewModel::detailsClicked
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun Loading() {
    AppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    }
}

@PreviewLightDark
@Composable
private fun Loaded(
    programmingLanguages: List<ProgrammingLanguage> = listOf(
        ProgrammingLanguage(
            stringResource(R.string.app_name),
            stringResource(R.string.app_name)
        ),
        ProgrammingLanguage(
            stringResource(R.string.app_name),
            stringResource(R.string.app_name)
        )
    ),
    detailsClicked: (String) -> Unit = {}
) {
    AppTheme {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(programmingLanguages) { programmingLanguage ->
                ProgrammingLanguageItem(
                    programmingLanguage,
                    detailsClicked
                )
            }
        }
    }
}

@Composable
private fun ProgrammingLanguageItem(
    programmingLanguage: ProgrammingLanguage,
    detailsClicked: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(programmingLanguage.name)
            Text(stringResource(R.string.designed_by, programmingLanguage.designed))
            Button(
                onClick = { detailsClicked(programmingLanguage.name) }) {
                Text(stringResource(R.string.details))
            }
        }
    }
}

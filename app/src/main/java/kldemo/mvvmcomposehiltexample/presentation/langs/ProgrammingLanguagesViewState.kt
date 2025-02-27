package kldemo.mvvmcomposehiltexample.presentation.langs

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage

data class ProgrammingLanguagesViewState(
    val programmingLanguages: List<ProgrammingLanguage>,
    val isLoading: Boolean
)

package kldemo.mvvmcomposehiltexample.presentation.lang_details

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails

data class ProgrammingLanguageDetailsViewState(
    val langName: String,
    val programmingLanguageDetails: ProgrammingLanguageDetails,
    val isLoading: Boolean
)

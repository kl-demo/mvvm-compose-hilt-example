package kldemo.mvvmcomposehiltexample.data.lang_details

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails

interface ProgrammingLanguageDetailsDataSource {
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}
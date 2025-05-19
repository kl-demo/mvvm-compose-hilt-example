package kldemo.mvvmcomposehiltexample.domain.lang_details

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails

interface ProgrammingLanguageDetailsManager {
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}
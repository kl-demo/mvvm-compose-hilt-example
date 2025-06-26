package kldemo.mvvmcomposehiltexample.data.core

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails

interface Api {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
    suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails
}
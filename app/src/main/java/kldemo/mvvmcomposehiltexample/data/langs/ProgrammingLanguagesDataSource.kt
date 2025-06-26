package kldemo.mvvmcomposehiltexample.data.langs

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage

interface ProgrammingLanguagesDataSource {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
}
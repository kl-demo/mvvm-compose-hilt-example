package kldemo.mvvmcomposehiltexample.domain.langs

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage

interface ProgrammingLanguagesManager {
    suspend fun getProgrammingLanguages(): List<ProgrammingLanguage>
}
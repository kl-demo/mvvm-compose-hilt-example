package kldemo.mvvmcomposehiltexample.domain.langs

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage
import kldemo.mvvmcomposehiltexample.data.langs.ProgrammingLanguagesDataSource
import javax.inject.Inject

class ProgrammingLanguagesManagerImpl @Inject constructor(private val programmingLanguagesDataSource: ProgrammingLanguagesDataSource) :
    ProgrammingLanguagesManager {

    override suspend fun getProgrammingLanguages(): List<ProgrammingLanguage> =
        programmingLanguagesDataSource.getProgrammingLanguages()
}
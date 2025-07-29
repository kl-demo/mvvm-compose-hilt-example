package kldemo.mvvmcomposehiltexample.data.langs

import kldemo.mvvmcomposehiltexample.data.core.Api
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguage
import javax.inject.Inject

class ProgrammingLanguagesDataSourceImpl @Inject constructor(private val api: Api) :
    ProgrammingLanguagesDataSource {

    override suspend fun getProgrammingLanguages(): List<ProgrammingLanguage> =
        api.getProgrammingLanguages()
}
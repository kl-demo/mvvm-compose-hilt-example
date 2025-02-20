package kldemo.mvvmcomposehiltexample.data.lang_details

import kldemo.mvvmcomposehiltexample.data.core.Api
import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails
import javax.inject.Inject

class ProgrammingLanguageDetailsDataSourceImpl @Inject constructor(private val api: Api) :
    ProgrammingLanguageDetailsDataSource {

    override suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails =
        api.getProgrammingLanguageDetails(name)
}
package kldemo.mvvmcomposehiltexample.domain.lang_details

import kldemo.mvvmcomposehiltexample.data.core.model.ProgrammingLanguageDetails
import kldemo.mvvmcomposehiltexample.data.lang_details.ProgrammingLanguageDetailsDataSource
import javax.inject.Inject

class ProgrammingLanguageDetailsManagerImpl @Inject constructor(private val programmingLanguageDetailsDataSource: ProgrammingLanguageDetailsDataSource) :
    ProgrammingLanguageDetailsManager {

    override suspend fun getProgrammingLanguageDetails(name: String): ProgrammingLanguageDetails =
        programmingLanguageDetailsDataSource.getProgrammingLanguageDetails(name)

}
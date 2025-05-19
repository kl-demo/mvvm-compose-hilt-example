package kldemo.mvvmcomposehiltexample.domain.lang_details

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kldemo.mvvmcomposehiltexample.data.lang_details.ProgrammingLanguageDetailsDataSource

@Module
@InstallIn(SingletonComponent::class)
object ProgrammingLanguageDetailsManagerModule {

    @Provides
    fun provideProgrammingLanguageDetailsManager(programmingLanguageDetailsDataSource: ProgrammingLanguageDetailsDataSource): ProgrammingLanguageDetailsManager =
        ProgrammingLanguageDetailsManagerImpl(programmingLanguageDetailsDataSource)
}
package kldemo.mvvmcomposehiltexample.data.counter

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CounterDataModule {

    @Provides
    fun provideCounterDataSource(): CounterDataSource = CounterDataSourceImpl()
}
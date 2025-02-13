package kldemo.mvvmcomposehiltexample.presentation.navigator

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class NavigatorModule {

    @Singleton
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}
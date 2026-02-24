package dev.marcosalis.clean.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.business.usecase.feature1.Feature1UseCase
import dev.marcosalis.clean.business.usecase.feature1.Feature1UseCaseImpl
import dev.marcosalis.clean.business.usecase.init.InitializeAppUseCase
import dev.marcosalis.clean.business.usecase.init.InitializeAppUseCaseImpl
import javax.inject.Singleton

/**
 * With KMP, the use case layer module is declared in the `app` Android module.
 * Dagger with KSP isn't supported on KMP modules.
 */
@Module
@InstallIn(SingletonComponent::class)
internal interface UseCaseModule {

    @Binds
    @Singleton
    fun initializeApp(impl: InitializeAppUseCaseImpl): InitializeAppUseCase

    @Binds
    fun feature1(impl: Feature1UseCaseImpl): Feature1UseCase

}

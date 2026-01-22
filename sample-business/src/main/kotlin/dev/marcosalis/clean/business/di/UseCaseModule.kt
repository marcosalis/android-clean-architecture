@file:Suppress("unused")

package dev.marcosalis.clean.business.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.business.feature1.Feature1UseCase
import dev.marcosalis.clean.business.feature1.Feature1UseCaseImpl
import dev.marcosalis.clean.business.init.InitializeAppUseCase
import dev.marcosalis.clean.business.init.InitializeAppUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface UseCaseModule {

    @Binds
    @Singleton
    fun initializeApp(impl: InitializeAppUseCaseImpl): InitializeAppUseCase

    @Binds
    fun feature1(impl: Feature1UseCaseImpl): Feature1UseCase

}

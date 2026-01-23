@file:Suppress("unused")

package dev.marcosalis.feature2.business.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.feature2.business.Feature2UseCase
import dev.marcosalis.feature2.business.Feature2UseCaseImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface UseCaseFeature2Module {

    @Binds
    fun feature1(impl: Feature2UseCaseImpl): Feature2UseCase

}

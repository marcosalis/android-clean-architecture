@file:Suppress("unused")

package dev.marcosalis.clean.feature2.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.data.access.Feature2Repository
import dev.marcosalis.clean.feature2.data.Feature2RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryFeature2Module {

    @Binds
    @Singleton
    fun feature2(impl: Feature2RepositoryImpl): Feature2Repository

}

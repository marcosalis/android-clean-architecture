@file:Suppress("unused")

package dev.marcosalis.clean.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import dev.marcosalis.clean.data.init.AppInitializationRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Binds
    @Singleton
    fun initializeApp(impl: AppInitializationRepositoryImpl): AppInitializationRepository

}

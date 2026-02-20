package dev.marcosalis.clean.data.injection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.data.access.feature1.Feature1Repository
import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import dev.marcosalis.clean.data.feature1.Feature1RepositoryImpl
import dev.marcosalis.clean.data.init.AppInitializationRepositoryImpl
import dev.marcosalis.clean.feature2.data.di.RepositoryFeature2Module
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule : RepositoryFeature2Module {

    @Binds
    @Singleton
    fun initializeApp(impl: AppInitializationRepositoryImpl): AppInitializationRepository

    @Binds
    @Singleton
    fun feature1(impl: Feature1RepositoryImpl): Feature1Repository

}

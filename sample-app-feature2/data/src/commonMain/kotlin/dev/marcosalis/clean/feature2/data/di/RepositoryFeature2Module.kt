@file:Suppress("unused")

package dev.marcosalis.clean.feature2.data.di

import dagger.Binds
import dagger.Module
import dev.marcosalis.clean.data.access.Feature2Repository
import dev.marcosalis.clean.feature2.data.Feature2RepositoryImpl
import javax.inject.Singleton

/**
 * Feature-specific Dagger module: extend common repository module with this to provide all declared
 * classes in the `SingletonComponent`.
 */
@Module
interface RepositoryFeature2Module {

    @Binds
    @Singleton
    fun feature2(impl: Feature2RepositoryImpl): Feature2Repository

}

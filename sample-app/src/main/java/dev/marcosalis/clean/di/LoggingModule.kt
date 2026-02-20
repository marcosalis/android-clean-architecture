package dev.marcosalis.clean.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.ktx.log.AndroidLogger
import dev.marcosalis.clean.ktx.log.Logger
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LoggingModule {

    @Provides
    @Singleton
    fun logger(): Logger = AndroidLogger()

}

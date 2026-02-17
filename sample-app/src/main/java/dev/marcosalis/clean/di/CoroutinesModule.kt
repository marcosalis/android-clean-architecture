package dev.marcosalis.clean.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.ktx.coroutines.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoroutinesModule {

    @Provides
    @Singleton
    fun dispatchers(): DispatcherProvider = object : DispatcherProvider {

        override val main: MainCoroutineDispatcher get() = Dispatchers.Main

        override val default: CoroutineDispatcher get() = Dispatchers.Default

        override val io: CoroutineDispatcher get() = Dispatchers.IO

        override val unconfined: CoroutineDispatcher get() = Dispatchers.Unconfined
    }
}

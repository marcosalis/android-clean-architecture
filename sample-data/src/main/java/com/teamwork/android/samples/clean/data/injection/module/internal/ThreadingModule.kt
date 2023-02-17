package com.teamwork.android.samples.clean.data.injection.module.internal

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Named
import javax.inject.Singleton

/**
 * [Module] that provide singleton [ExecutorService] for thread pools that will be reused across the application.
 *
 * This could also include custom RxJava `Scheduler`s or any other global, cross-layer threading dependency.
 */
@Module
@InstallIn(SingletonComponent::class)
internal object ThreadingModule {

    @Provides
    @Singleton
    @Named(DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR)
    fun computationExecutorService(): ExecutorService =
        // note: this thread pool sizing isn't reliable, it's just provided as an example
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()).also {
            Timber.i("Initializing computation '${ExecutorService::class.simpleName}' (singleton)")
        }

    @Provides
    @Singleton
    @Named(DataAccessComponent.GLOBAL_IO_EXECUTOR)
    fun ioExecutorService(): ExecutorService = Executors.newCachedThreadPool().also {
        Timber.i("Initializing IO '${ExecutorService::class.simpleName}' (singleton)")
    }

}

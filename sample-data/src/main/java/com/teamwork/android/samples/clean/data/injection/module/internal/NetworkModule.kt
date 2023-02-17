package com.teamwork.android.samples.clean.data.injection.module.internal

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.teamwork.android.samples.clean.data.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

/**
 * Module that provides singleton components for networking dependencies and API.
 */
@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    //region OkHttp

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BASIC
            else
                HttpLoggingInterceptor.Level.NONE
        return OkHttpClient.Builder()
            .addNetworkInterceptor(loggingInterceptor)
            .retryOnConnectionFailure(true)
            .build()
    }

    //endregion

    //region JSON (de)serialization with Moshi

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

}

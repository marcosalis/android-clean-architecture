package dev.marcosalis.clean

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SampleApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak") // app context is global to the process
        lateinit var INSTANCE: Context
    }

    override fun onCreate() {
        INSTANCE = this
        super.onCreate()

        initializeTimber()

        Timber.d("Application.onCreate()")
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
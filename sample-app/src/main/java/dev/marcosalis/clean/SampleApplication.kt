package dev.marcosalis.clean

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.Lazy
import dagger.hilt.android.HiltAndroidApp
import dev.marcosalis.clean.business.usecase.init.InitializeAppUseCase
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class SampleApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak") // app context is global to the process
        lateinit var INSTANCE: Context
    }

    @Inject
    @ProcessScope
    internal lateinit var processScope: CoroutineScope

    @Inject internal lateinit var initUseCase: Lazy<InitializeAppUseCase>

    override fun onCreate() {
        INSTANCE = this
        super.onCreate()

        initializeTimber()
        Timber.d("Application.onCreate()")

        initialize()
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initialize() {
        processScope.launch {
            initUseCase.get().initialize()
        }
    }
}

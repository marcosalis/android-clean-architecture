@file:Suppress("RedundantOverride")

package com.teamwork.android.samples.clean.app

import android.app.Application
import com.teamwork.android.samples.clean.business.SampleBusinessApplication
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Projects [Application] concrete class.
 *
 * Don't use for lengthy unnecessary initializations, as anything executed here on the main thread will delay the
 * application startup and UI.
 */
@HiltAndroidApp
class SampleApplication : SampleBusinessApplication() {

    companion object {

        lateinit var instance: SampleApplication
            private set

    }

    override fun onCreate() {
        instance = this
        Timber.plant(Timber.DebugTree())

        super.onCreate()
    }

    override fun initializeAppComponent(businessComponent: BusinessComponent) {
    }

    override fun initializeDataComponent() {
    }

    override fun initializeNetworkLayer() {
    }

    override fun initializeCacheLayer() {
    }

    override fun onDependencyManagementInitialized() {
        super.onDependencyManagementInitialized()

        // initialize here presentation/view layers if necessary
    }

}

@file:Suppress("unused", "UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.injection

import android.content.Context
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Initializer class for the `data` layer.
 *
 * It takes care of triggering the initialization of the [DataComponent] from [initialize], and of all the
 * other layer initialization code dependent on the component in [initializeNetworkLayer] and [initializeCacheLayer].
 *
 * FIXME: we probably don't need this anymore
 */
@Singleton
@ThreadSafe
class DataLayerInitializer {

    @Inject
    lateinit var entity1Repo: Entity1Repo

    fun initialize(appContext: Context) {
        // initializeDataComponent(appContext)

        // DataComponent.INSTANCE.inject(this)
    }

    private fun initializeDataComponent(appContext: Context): DataComponent {
//        val dataComponent = DaggerDataComponent.factory().create(appContext)
//        DataComponent.INSTANCE = dataComponent
//        DataAccessComponent.INSTANCE = dataComponent
        // return dataComponent
        TODO()
    }

    fun initializeNetworkLayer(appContext: Context) {}

    fun initializeCacheLayer(appContext: Context) {}

}
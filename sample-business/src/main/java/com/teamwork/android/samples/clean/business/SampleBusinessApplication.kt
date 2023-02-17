@file:Suppress("MemberVisibilityCanBePrivate")

package com.teamwork.android.samples.clean.business

import android.app.Application
import androidx.annotation.CallSuper
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import dagger.hilt.EntryPoints

/**
 * Contains business layer specific initialization for the main sample [Application] concrete class.
 */
abstract class SampleBusinessApplication : Application() {

    //endregion

    protected val businessComponent: BusinessComponent
            by lazy { EntryPoints.get(this, BusinessComponent::class.java) }

    override fun onCreate() {
        super.onCreate()

        // the order of these calls is fundamental for a correct initialization, do NOT modify!
        initializeErrorManagement()
        initializeGlobalDependencyManagement()
        initializeLayers()
    }

    protected fun initializeErrorManagement() {}

    //region initialize global dependency injection

    protected fun initializeGlobalDependencyManagement() {
        // TODO: we can probably remove this
        onDependencyManagementInitialized()
    }

    protected abstract fun initializeAppComponent(businessComponent: BusinessComponent)

    protected abstract fun initializeDataComponent()

    /**
     * Initialize any network-related component, such as network API containers, OkHttp and any web sockets.
     */
    protected abstract fun initializeNetworkLayer()

    /**
     * Initialize global caching components.
     */
    protected abstract fun initializeCacheLayer()

    protected fun initializeBusinessLayer() {
    }

    @CallSuper
    protected open fun onDependencyManagementInitialized() {
    }

    @CallSuper
    protected open fun initializeLayers() {
        initializeNetworkLayer()
        initializeCacheLayer()
        initializeBusinessLayer()
    }

}

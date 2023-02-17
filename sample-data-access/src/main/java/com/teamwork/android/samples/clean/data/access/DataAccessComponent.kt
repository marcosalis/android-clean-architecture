package com.teamwork.android.samples.clean.data.access

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Interface that lists all public 'data access' layer components which need to be exposed to the `business` layer.
 *
 * When Dagger is used, by letting the Dagger Component from the 'data layer' extend this interface we declare
 * [provision methods](https://dagger.dev/api/2.25.2/dagger/Component.html) which then can be used by injected
 * classes in the business layer.
 */
@EntryPoint
@InstallIn(SingletonComponent::class)
interface DataAccessComponent {

    companion object {

        const val GLOBAL_COMPUTATION_EXECUTOR = "computation_executor"
        const val GLOBAL_IO_EXECUTOR = "IO_executor"
    }

}

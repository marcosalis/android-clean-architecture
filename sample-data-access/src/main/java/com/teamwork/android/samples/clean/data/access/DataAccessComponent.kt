package com.teamwork.android.samples.clean.data.access

/**
 * Interface that lists all public 'data access' layer components which need to be exposed to the `business` layer.
 *
 * When Dagger is used, by letting the Dagger Component from the 'data layer' extend this interface we declare
 * [provision methods](https://dagger.dev/api/2.25.2/dagger/Component.html) which then can be used by injected
 * classes in the business layer.
 */
interface DataAccessComponent {

    companion object {

        const val GLOBAL_COMPUTATION_EXECUTOR = "computation_executor"
        const val GLOBAL_IO_EXECUTOR = "IO_executor"
    }

}

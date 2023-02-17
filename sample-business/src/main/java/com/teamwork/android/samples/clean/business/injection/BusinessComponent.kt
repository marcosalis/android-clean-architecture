package com.teamwork.android.samples.clean.business.injection

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BusinessComponent {

    companion object {
        const val GLOBAL_COMPUTATION_EXECUTOR = DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR
        const val GLOBAL_IO_EXECUTOR = DataAccessComponent.GLOBAL_IO_EXECUTOR
    }

}

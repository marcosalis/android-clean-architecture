package dev.marcosalis.clean.di

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(SingletonComponent::class)
internal object ProcessLifecycleModule {

    /**
     * This scope is bound to the process lifecycle and uses a `SupervisorJob` to ensure a
     * failure in one of its children doesn't affect the others.
     */
    private val PROCESS_SCOPE: CoroutineScope = ProcessLifecycleOwner.get().lifecycleScope

    @Provides
    @ProcessScope
    fun processScope(): CoroutineScope = PROCESS_SCOPE

}

package dev.marcosalis.clean.data.init

import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import dev.marcosalis.clean.ktx.coroutines.DispatcherProvider
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class AppInitializationRepositoryImpl @Inject constructor(
    @param:ProcessScope private val processScope: CoroutineScope,
    private val dispatchers: DispatcherProvider
) : AppInitializationRepository {

    override suspend fun initialize() {
        processScope.launch(Dispatchers.Default) {
            // do asynchronous stuff
        }

        withContext(dispatchers.default) {
            // do stuff
        }
    }
}

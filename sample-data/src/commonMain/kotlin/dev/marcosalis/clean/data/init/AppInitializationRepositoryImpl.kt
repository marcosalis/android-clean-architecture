package dev.marcosalis.clean.data.init

import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import dev.marcosalis.clean.ktx.coroutines.DispatcherProvider
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import dev.marcosalis.clean.ktx.log.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AppInitializationRepositoryImpl @Inject constructor(
    private val logger: Logger,
    @param:ProcessScope private val processScope: CoroutineScope,
    private val dispatchers: DispatcherProvider
) : AppInitializationRepository {

    override suspend fun initialize() {
        logger.i("Initializing application...")

        processScope.launch(dispatchers.default) {
            // do asynchronous stuff
        }

        withContext(dispatchers.default) {
            // do stuff
        }
    }
}

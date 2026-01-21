package dev.marcosalis.clean.data.init

import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class AppInitializationRepositoryImpl @Inject constructor(
    @param:ProcessScope private val processScope: CoroutineScope
) : AppInitializationRepository {

    override suspend fun initialize() {
        processScope.launch(Dispatchers.Default) {
            // do asynchronous stuff
        }

        withContext(Dispatchers.Default) {
            // do stuff
        }
    }
}

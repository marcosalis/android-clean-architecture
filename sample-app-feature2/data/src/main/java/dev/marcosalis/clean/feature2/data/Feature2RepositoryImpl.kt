package dev.marcosalis.clean.feature2.data

import dev.marcosalis.clean.data.access.Feature2Repository
import dev.marcosalis.clean.feature2.entity.Feature2Action
import dev.marcosalis.clean.ktx.coroutines.ProcessScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class Feature2RepositoryImpl @Inject constructor(
    @param:ProcessScope private val processScope: CoroutineScope
) : Feature2Repository {

    override suspend fun doStuff(payload: Feature2Action) {
        processScope.launch(Dispatchers.IO) {
            // networking actions etc.
        }
    }
}

package dev.marcosalis.clean.data.feature1

import dev.marcosalis.clean.business.entity.feature1.Feature1
import dev.marcosalis.clean.business.entity.feature1.Feature1Action
import dev.marcosalis.clean.data.access.feature1.Feature1Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

internal class Feature1RepositoryImpl @Inject constructor() : Feature1Repository {

    override val data: Flow<Feature1> =
        // this data will likely be fetched from a data source or cache
        flow {
            delay(500) // simulate network delay

            emit(
                Feature1(
                    id = "id1",
                    parameter1 = "Feature 1"
                )
            )
        }
            .flowOn(Dispatchers.Default)

    override suspend fun performAction(payload: Feature1Action) {
        // networking actions etc.
    }
}

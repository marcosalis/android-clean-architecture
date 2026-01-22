package dev.marcosalis.clean.business.feature1

import dev.marcosalis.clean.business.entity.feature1.Feature1
import dev.marcosalis.clean.business.entity.feature1.Feature1Action
import dev.marcosalis.clean.data.access.feature1.Feature1Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class Feature1UseCaseImpl @Inject constructor(
    private val repository: Feature1Repository
) : Feature1UseCase {

    // data Flow is only propagated, but it could be filtered or mapped according to business rules
    override val data: Flow<Feature1> = repository.data

    override suspend fun performAction(payload: Feature1Action) {
        if (payload.canPerformAction()) {
            repository.performAction(payload)
        } else {
            // error management, user notification etc.
        }
    }
}

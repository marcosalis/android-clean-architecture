package dev.marcosalis.feature2.business

import dev.marcosalis.clean.data.access.Feature2Repository
import dev.marcosalis.clean.feature2.entity.Feature2Action
import javax.inject.Inject

internal class Feature2UseCaseImpl @Inject constructor(
    private val repository: Feature2Repository
) : Feature2UseCase {

    override suspend fun doStuff(payload: Feature2Action) {
        repository.doStuff(payload)
    }
}

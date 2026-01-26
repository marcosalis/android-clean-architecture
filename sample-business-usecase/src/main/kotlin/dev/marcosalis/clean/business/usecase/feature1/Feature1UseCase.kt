package dev.marcosalis.clean.business.usecase.feature1

import dev.marcosalis.clean.business.entity.feature1.Feature1
import dev.marcosalis.clean.business.entity.feature1.Feature1Action
import kotlinx.coroutines.flow.Flow

interface Feature1UseCase {

    val data: Flow<Feature1>

    suspend fun performAction(payload: Feature1Action)

}

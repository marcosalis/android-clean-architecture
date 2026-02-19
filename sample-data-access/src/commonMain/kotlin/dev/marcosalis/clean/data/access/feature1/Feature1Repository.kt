package dev.marcosalis.clean.data.access.feature1

import dev.marcosalis.clean.business.entity.feature1.Feature1
import dev.marcosalis.clean.business.entity.feature1.Feature1Action
import kotlinx.coroutines.flow.Flow

interface Feature1Repository {

    val data: Flow<Feature1>

    suspend fun performAction(payload: Feature1Action)

}

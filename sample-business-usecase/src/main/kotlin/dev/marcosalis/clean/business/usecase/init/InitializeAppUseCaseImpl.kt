package dev.marcosalis.clean.business.usecase.init

import dev.marcosalis.clean.data.access.init.AppInitializationRepository
import javax.inject.Inject

internal class InitializeAppUseCaseImpl @Inject constructor(
    private val appInitRepository: AppInitializationRepository
) : InitializeAppUseCase {

    override suspend fun initialize() = appInitRepository.initialize()
}

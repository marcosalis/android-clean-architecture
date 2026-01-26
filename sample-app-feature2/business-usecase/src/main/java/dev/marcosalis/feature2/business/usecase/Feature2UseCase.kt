package dev.marcosalis.feature2.business.usecase

import dev.marcosalis.clean.feature2.entity.Feature2Action

interface Feature2UseCase {

    suspend fun doStuff(payload: Feature2Action)

}

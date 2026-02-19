package dev.marcosalis.clean.data.access

import dev.marcosalis.clean.feature2.entity.Feature2Action

interface Feature2Repository {

    suspend fun doStuff(payload: Feature2Action)

}

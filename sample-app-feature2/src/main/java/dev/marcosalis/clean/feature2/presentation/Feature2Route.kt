package dev.marcosalis.clean.feature2.presentation

import kotlinx.serialization.Serializable

@Serializable
data class Feature2Route(
    val id: String,
    val parameter1: Boolean = false
)

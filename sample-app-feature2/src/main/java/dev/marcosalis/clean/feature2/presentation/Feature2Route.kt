package dev.marcosalis.clean.feature2.presentation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class Feature2Route(
    val id: String,
    val parameter1: Boolean = false
) : NavKey

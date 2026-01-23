package dev.marcosalis.clean.feature2.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marcosalis.clean.feature2.presentation.Feature2Route
import dev.marcosalis.clean.feature2.presentation.Feature2ViewModel

fun NavController.navigateToFeature2(id: String) {
    navigate(route = Feature2Route(id = id)) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavGraphBuilder.feature2Destination() {
    composable<Feature2Route> {
        Feature2Entry()
    }
}

@Composable
private fun Feature2Entry(
    viewModel: Feature2ViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Feature2Screen(uiState = uiState)
}

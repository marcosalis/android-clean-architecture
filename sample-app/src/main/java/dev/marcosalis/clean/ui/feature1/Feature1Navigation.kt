package dev.marcosalis.clean.ui.feature1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marcosalis.clean.presentation.feature1.Feature1Route
import dev.marcosalis.clean.presentation.feature1.Feature1ViewModel

fun NavController.navigateToFeature1(id: String) {
    navigate(route = Feature1Route(id = id))
}

fun NavGraphBuilder.feature1Destination() {
    composable<Feature1Route> {
        Feature1Entry()
    }
}

@Composable
private fun Feature1Entry(
    viewModel: Feature1ViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Feature1Screen(uiState = uiState)
}

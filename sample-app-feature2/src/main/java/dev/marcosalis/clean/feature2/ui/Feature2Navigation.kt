package dev.marcosalis.clean.feature2.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.marcosalis.clean.feature2.presentation.Feature2Route
import dev.marcosalis.clean.feature2.presentation.Feature2ViewModel

interface Feature2Navigator {

    fun navigateToFeature2(id: String)

    fun navigateBack()

}

fun EntryProviderScope<NavKey>.feature2Entry(navigator: Feature2Navigator) {
    entry<Feature2Route> { route ->
        Feature2Entry(route = route, navigator = navigator)
    }
}

@Composable
private fun Feature2Entry(
    navigator: Feature2Navigator,
    route: Feature2Route,
    viewModel: Feature2ViewModel = hiltViewModel<Feature2ViewModel, Feature2ViewModel.Factory>(
        creationCallback = { factory -> factory.create(route) }
    ),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Feature2Screen(
        uiState = uiState,
        onGoBack = { navigator.navigateBack() }
    )
}

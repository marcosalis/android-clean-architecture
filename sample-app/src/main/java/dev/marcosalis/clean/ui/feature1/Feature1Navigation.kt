package dev.marcosalis.clean.ui.feature1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.marcosalis.clean.presentation.common.SharedViewModel
import dev.marcosalis.clean.presentation.feature1.Feature1Route
import dev.marcosalis.clean.presentation.feature1.Feature1ViewModel
import dev.marcosalis.clean.ui.navigation.LocalActivityViewModelStoreOwner
import dev.marcosalis.clean.ui.navigation.LocalFeatureNavigator
import dev.marcosalis.clean.ui.navigation.Navigator

fun Navigator.navigateToFeature1() = navigate(Feature1Route)

fun EntryProviderScope<NavKey>.feature1Entry() {
    entry<Feature1Route> {
        Feature1Entry()
    }
}

@Composable
private fun Feature1Entry(
    // ties shared ViewModel instance lifecycle to the current Activity
    @Suppress("unused") sharedViewModel: SharedViewModel = hiltViewModel(
        viewModelStoreOwner = LocalActivityViewModelStoreOwner.current
    ),
    viewModel: Feature1ViewModel = hiltViewModel()
) {
    val featureNavigator = LocalFeatureNavigator.current
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Feature1Screen(
        uiState = uiState,
        onFeature2Click = { featureNavigator.navigateToFeature2(it) }
    )
}

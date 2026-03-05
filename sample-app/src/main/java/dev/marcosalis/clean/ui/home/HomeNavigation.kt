package dev.marcosalis.clean.ui.home

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import dev.marcosalis.clean.presentation.common.SharedViewModel
import dev.marcosalis.clean.presentation.home.HomeRoute
import dev.marcosalis.clean.presentation.home.HomeViewModel
import dev.marcosalis.clean.ui.navigation.LocalActivityViewModelStoreOwner
import dev.marcosalis.clean.ui.navigation.Navigator

fun Navigator.navigateToHome() = navigate(HomeRoute)

fun EntryProviderScope<NavKey>.homeEntry() {
    entry<HomeRoute> {
        HomeScreenEntry()
    }
}

@Composable
private fun HomeScreenEntry(
    // ties shared ViewModel instance lifecycle to the current Activity
    @Suppress("unused") sharedViewModel: SharedViewModel = hiltViewModel(
        viewModelStoreOwner = LocalActivityViewModelStoreOwner.current
    ),
    @Suppress("unused") viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen()
}

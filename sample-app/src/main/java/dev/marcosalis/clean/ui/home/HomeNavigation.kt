package dev.marcosalis.clean.ui.home

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.marcosalis.clean.presentation.home.HomeRoute
import dev.marcosalis.clean.presentation.home.HomeViewModel

fun NavController.navigateToHome() = navigate(route = HomeRoute) {
    popUpTo(graph.findStartDestination().id) { saveState = true }
    launchSingleTop = true
    restoreState = true
}

fun NavGraphBuilder.homeDestination() {
    composable<HomeRoute> {
        HomeScreenEntry()
    }
}

@Composable
private fun HomeScreenEntry(
    @Suppress("unused") viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen()
}

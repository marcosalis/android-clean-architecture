package dev.marcosalis.clean.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.marcosalis.clean.feature2.presentation.Feature2Route
import dev.marcosalis.clean.feature2.ui.feature2Destination
import dev.marcosalis.clean.feature2.ui.navigateToFeature2
import dev.marcosalis.clean.presentation.feature1.Feature1Route
import dev.marcosalis.clean.presentation.home.HomeRoute
import dev.marcosalis.clean.ui.feature1.feature1Destination
import dev.marcosalis.clean.ui.feature1.navigateToFeature1
import dev.marcosalis.clean.ui.home.homeDestination
import dev.marcosalis.clean.ui.home.navigateToHome

@Composable
fun AppHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            AppBottomNavigationBar(
                isHomeSelected = currentDestination?.hasRoute<HomeRoute>() == true,
                isFeature1Selected = currentDestination?.hasRoute<Feature1Route>() == true,
                isFeature2Selected = currentDestination?.hasRoute<Feature2Route>() == true,
                onHomeClick = { navController.navigateToHome() },
                onFeature1Click = { navController.navigateToFeature1("id1") },
                onFeature2Click = { navController.navigateToFeature2("id2") }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeRoute,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeDestination()

            feature1Destination()

            feature2Destination() // from feature module `feature2`
        }
    }
}

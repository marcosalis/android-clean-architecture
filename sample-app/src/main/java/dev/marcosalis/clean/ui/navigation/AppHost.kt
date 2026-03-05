package dev.marcosalis.clean.ui.navigation

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.scene.DialogSceneStrategy
import androidx.navigation3.ui.NavDisplay
import dev.marcosalis.clean.feature2.ui.feature2Entry
import dev.marcosalis.clean.presentation.feature1.Feature1Route
import dev.marcosalis.clean.presentation.home.HomeRoute
import dev.marcosalis.clean.ui.feature1.feature1Entry
import dev.marcosalis.clean.ui.feature1.navigateToFeature1
import dev.marcosalis.clean.ui.home.homeEntry
import dev.marcosalis.clean.ui.home.navigateToHome


@Composable
fun AppHost(
    modifier: Modifier = Modifier
) {
    val navigationState = rememberNavigationState(
        startRoute = HomeRoute,
        topLevelRoutes = setOf(HomeRoute, Feature1Route)
    )

    val navigator = remember { Navigator(navigationState) }
    val featureNavigator = remember(navigator) { FeatureNavigator(navigator) }

    // val topLevelRoute = navigator.state.topLevelRoute
    // val currentDestination = navigator.state.backStacks[topLevelRoute]?.last()

    CompositionLocalProvider(
        LocalNavigator provides navigator,
        LocalFeatureNavigator provides featureNavigator,
        LocalActivityViewModelStoreOwner provides LocalActivity.current as ComponentActivity
    ) {
        val entryProvider = entryProvider {
            homeEntry()

            feature1Entry()
            feature2Entry(navigator = LocalFeatureNavigator.current) // from feature module `feature2`
        }

        Scaffold(
            modifier = modifier.fillMaxSize(),
            bottomBar = {
                AppBottomNavigationBar(
                    isHomeSelected = HomeRoute == navigationState.topLevelRoute,
                    isFeature1Selected = Feature1Route == navigationState.topLevelRoute,
                    onHomeClick = { navigator.navigateToHome() },
                    onFeature1Click = { navigator.navigateToFeature1() }
                )
            }
        ) { innerPadding ->
            NavDisplay(
                entries = navigationState.toEntries(entryProvider),
                onBack = { navigator.goBack() },
                sceneStrategy = remember { DialogSceneStrategy() },
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

val LocalActivityViewModelStoreOwner = staticCompositionLocalOf<ViewModelStoreOwner> {
    error("No activity ViewModelStoreOwner provided!")
}
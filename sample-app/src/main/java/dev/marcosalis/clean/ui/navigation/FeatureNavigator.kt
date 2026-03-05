package dev.marcosalis.clean.ui.navigation

import androidx.compose.runtime.staticCompositionLocalOf
import dev.marcosalis.clean.feature2.presentation.Feature2Route
import dev.marcosalis.clean.feature2.ui.Feature2Navigator

val LocalFeatureNavigator = staticCompositionLocalOf<FeatureNavigator> {
    error("No FeatureNavigator provided!")
}

/**
 * [Navigator] decorator to access feature modules routes.
 *
 * Note: this doesn't scale well with large codebases and a big number of routes; a different
 * approach might be to create separate implementations for each feature module navigation items.
 *
 * Navigation 3 doesn't recommend specific guidelines. A shared `core-navigation` module with common
 * navigation interfaces might be better suited for large codebases, when the priority is to keep
 * feature modules as independent as possible.
 */
class FeatureNavigator(private val navigator: Navigator) : Feature2Navigator {

    override fun navigateToFeature2(id: String) {
        navigator.navigate(Feature2Route(id = id))
    }

    override fun navigateBack() {
        navigator.goBack()
    }
}

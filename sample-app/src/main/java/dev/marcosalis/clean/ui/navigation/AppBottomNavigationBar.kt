package dev.marcosalis.clean.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DataArray
import androidx.compose.material.icons.filled.DonutLarge
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AppBottomNavigationBar(
    isHomeSelected: Boolean,
    isFeature1Selected: Boolean,
    isFeature2Selected: Boolean,
    onHomeClick: () -> Unit,
    onFeature1Click: () -> Unit,
    onFeature2Click: () -> Unit
) {
    NavigationBar {
        NavigationBarItem(
            selected = isHomeSelected,
            onClick = onHomeClick,
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = { Text(text = "Home") }
        )
        NavigationBarItem(
            selected = isFeature1Selected,
            onClick = onFeature1Click,
            icon = {
                Icon(
                    imageVector = Icons.Default.DonutLarge,
                    contentDescription = "Feature 1"
                )
            },
            label = { Text(text = "Feature 1") }
        )
        NavigationBarItem(
            selected = isFeature2Selected,
            onClick = onFeature2Click,
            icon = {
                Icon(
                    imageVector = Icons.Default.DataArray,
                    contentDescription = "Feature 2"
                )
            },
            label = { Text(text = "Feature 2") }
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun AppBottomNavigationBarPreview() {
    AppBottomNavigationBar(
        isHomeSelected = true,
        isFeature1Selected = false,
        isFeature2Selected = false,
        onHomeClick = {},
        onFeature1Click = {},
        onFeature2Click = {}
    )
}

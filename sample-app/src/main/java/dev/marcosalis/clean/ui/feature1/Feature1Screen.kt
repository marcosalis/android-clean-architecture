package dev.marcosalis.clean.ui.feature1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.marcosalis.clean.presentation.feature1.Feature1UiState
import dev.marcosalis.clean.ui.theme.CleanArchitectureAppTheme

@Composable
fun Feature1Screen(uiState: Feature1UiState) {
    Feature1Header(
        modifier = Modifier,
        uiState = uiState
    )
}

@Composable
private fun Feature1Header(
    modifier: Modifier = Modifier,
    uiState: Feature1UiState
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        if (uiState.showText) {
            Text(
                text = uiState.text,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Feature1HeaderPreview() {
    CleanArchitectureAppTheme {
        Feature1Header(
            uiState = Feature1UiState(
                id = "test",
                showText = true,
                text = "Feature 1"
            )
        )
    }
}

package dev.marcosalis.clean.feature2.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.marcosalis.clean.feature2.presentation.Feature2UiState

@Composable
internal fun Feature2Screen(@Suppress("unused") uiState: Feature2UiState) {
    Feature2Header()
}

@Composable
private fun Feature2Header(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Feature 2",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun Feature2HeaderPreview() {
    // note: we don't use an application theme as this is a reusable feature module
    Feature2Header()
}

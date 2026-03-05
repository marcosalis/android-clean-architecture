package dev.marcosalis.clean.feature2.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.marcosalis.clean.feature2.presentation.Feature2UiState

@Composable
internal fun Feature2Screen(
    @Suppress("unused") uiState: Feature2UiState,
    onGoBack: () -> Unit,
) {
    Feature2Header(onGoBack = onGoBack)
}

@Composable
private fun Feature2Header(
    onGoBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Feature 2")

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { onGoBack() }) { Text("Go back") }
    }
}

@Composable
@Preview(showBackground = true)
private fun Feature2HeaderPreview() {
    // note: we don't use an application theme as this is a reusable feature module
    Feature2Header(onGoBack = {})
}

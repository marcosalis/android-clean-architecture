package dev.marcosalis.clean.ui.feature1

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
import dev.marcosalis.clean.presentation.feature1.Feature1UiState
import dev.marcosalis.clean.ui.theme.CleanArchitectureAppTheme

@Composable
fun Feature1Screen(
    uiState: Feature1UiState,
    onFeature2Click: (String) -> Unit,
) {
    Feature1Header(
        uiState = uiState,
        onFeature2Click = onFeature2Click,
        modifier = Modifier,
    )
}

@Composable
private fun Feature1Header(
    uiState: Feature1UiState,
    onFeature2Click: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (uiState.showText) {
            Text(
                text = uiState.text
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { onFeature2Click(uiState.id) }) { Text("Feature 2") }
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
            ),
            onFeature2Click = {}
        )
    }
}

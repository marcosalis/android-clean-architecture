package dev.marcosalis.clean.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.marcosalis.clean.ui.theme.CleanArchitectureAppTheme

@Composable
fun HomeScreen() {
    Header(
        modifier = Modifier
    )
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Clean Architecture on Android",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun HeaderPreview() {
    CleanArchitectureAppTheme {
        Header()
    }
}

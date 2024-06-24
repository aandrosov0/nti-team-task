package aandrosov.app.client.ui.components

import aandrosov.app.client.ui.state.getFolders
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
        ) {
            InformationBlock(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .weight(1F),
                m1MmaxValue = "2GB/4GB",
                files = getFolders()
            )
            ActionButtons(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                onStartButton = { /*TODO*/ },
                onConfigButton = { /*TODO*/ },
                onScanListButton = { /*TODO*/ },
                isStartButtonActive = false
            )
        }
    }
}

@Preview
@Composable
private fun AppScreenPreview() {
    AppScreen()
}
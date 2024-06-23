package aandrosov.app.client.ui.components

import aandrosov.app.client.R
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartButton(
    active: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    ) {
        val textId = if (active) R.string.stop else R.string.start
        Text(text = stringResource(id = textId))
    }
}

@Composable
fun ActionButtons(
    onStartButton: () -> Unit,
    onConfigButton: () -> Unit,
    onScanListButton: () -> Unit,
    isStartButtonActive: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        StartButton(
            active = isStartButtonActive,
            onClick = onStartButton
        )
        Button(onClick = onConfigButton) {
            Text(text = stringResource(id = R.string.config))
        }
        Button(onClick = onScanListButton) {
            Text(text = stringResource(id = R.string.scan_list))
        }
    }
}

@Preview
@Composable
private fun StartButtonPreview() {
    var active by remember { mutableStateOf(false) }
    StartButton(
        active = active,
        onClick = { active = !active }
    )
}

@Preview
@Composable
private fun ActionButtonsPreview() {
    var isStartButtonActive by remember { mutableStateOf(false) }
    ActionButtons(
        onStartButton = { isStartButtonActive = !isStartButtonActive },
        onConfigButton = { },
        onScanListButton = { },
        isStartButtonActive = isStartButtonActive
    )
}
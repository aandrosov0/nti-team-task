package aandrosov.app.client.ui.components

import aandrosov.app.client.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    active: Boolean = false,
    enabled: Boolean = true
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
fun ExpandButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    expanded: Boolean = false
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        val id = if (expanded) R.drawable.expand_less else R.drawable.expand_more
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = id),
            contentDescription = null
        )
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
private fun ExpandButtonPreview() {
    var expanded by remember { mutableStateOf(false) }
    ExpandButton(
        expanded = expanded,
        onClick = { expanded = !expanded }
    )
}
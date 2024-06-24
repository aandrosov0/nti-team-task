package aandrosov.app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Node(
    name: String,
    expanded: Boolean,
    onExpand: () -> Unit,
    prefix: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    expandable: Boolean = true,
    content: @Composable () -> Unit = {},
) {
    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            prefix()
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = name
            )
            if (expandable) {
                ExpandButton(
                    expanded = expanded,
                    onClick = onExpand
                )
            }
        }
        if (expanded) {
            content()
        }
    }
}

@Preview
@Composable
private fun NodePreview() {
    var expanded by remember { mutableStateOf(false) }
    Node(
        name = "Node Name",
        expanded = expanded,
        onExpand = { expanded = !expanded },
        prefix = { Text(text = "Prefix") },
    ) {
        Text(text = "Post Fix")
    }
}
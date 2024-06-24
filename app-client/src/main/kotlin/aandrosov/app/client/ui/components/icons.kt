package aandrosov.app.client.ui.components

import aandrosov.app.client.R
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatusIcon(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.circle),
        contentDescription = null,
        tint = color
    )
}

@Preview
@Composable
private fun StatusIconPreview() {
    StatusIcon(color = Color.Green)
}

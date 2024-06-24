package aandrosov.app.client.ui.components

import aandrosov.app.client.R
import aandrosov.app.client.ui.state.FileState
import aandrosov.app.client.ui.state.getFolders
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InformationBlock(
    modifier: Modifier = Modifier,
    m1MmaxValue: String = stringResource(id = R.string.m1_mmax),
    files: List<FileState> = emptyList()
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = m1MmaxValue,
            style = MaterialTheme.typography.titleLarge
        )
        Text(text = stringResource(id = R.string.scan))
        FilesTree(
            modifier = Modifier
                .padding(top = 16.dp)
                .horizontalScroll(rememberScrollState()),
            files = files
        )
    }
}

@Preview
@Composable
private fun InformationBlockPreview() {
    InformationBlock(
        m1MmaxValue = "2GB/4GB",
        files = getFolders()
    )
}
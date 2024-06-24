package aandrosov.app.client.ui.components

import aandrosov.app.client.ui.state.FileState
import aandrosov.app.client.ui.state.FileStatus
import aandrosov.app.client.ui.state.FolderState
import aandrosov.app.client.ui.state.getFolders
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FileRepresentation(
    modifier: Modifier = Modifier,
    file: FileState
) {
    var expanded by remember { mutableStateOf(false) }
    aandrosov.app.ui.components.Node(
        modifier = modifier,
        name = file.name,
        expanded = expanded,
        expandable = file is FolderState,
        onExpand = { expanded = !expanded },
        prefix = {
            if (file !is FolderState) {
                aandrosov.app.ui.components.StatusIcon(color = file.status.color)
            }
        }
    ) {
        if (file is FolderState) {
            file.files.forEach { file ->
                FileRepresentation(
                    modifier = Modifier
                        .padding(start = 16.dp),
                    file = file
                )
            }
        }
    }
}

@Composable
fun FilesTree(
    files: List<FileState>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = files) { file ->
            FileRepresentation(file = file)
        }
    }
}

@Preview
@Composable
private fun FileRepresentationPreview() {
    FileRepresentation(
        file = FileState(
            name = "File Name",
            status = FileStatus.GREEN
        )
    )
}

@Preview
@Composable
private fun FilesTreePreview() {
    FilesTree(files = getFolders())
}
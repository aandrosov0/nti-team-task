package aandrosov.app.client.ui.state

import androidx.compose.ui.graphics.Color

open class FileState(
    val name: String = "",
    val status: FileStatus = FileStatus.GREEN
)

enum class FileStatus(val color: Color) {
    GREEN(Color.Green),
    VIOLET(Color.Magenta);
}

package aandrosov.app.client.ui.state

class FolderState(
    name: String = "",
    status: FileStatus = FileStatus.GREEN,
    val files: List<FileState> = emptyList()
) : FileState(
    name = name,
    status = status
)

fun getFolders(): List<FolderState> = buildList {
    for (i in 1..3) {
        add(
            FolderState(
                name = "Folder $i",
                files = buildList {
                    for (j in 1..5) {
                        add(
                            FileState(
                                name = "File $j",
                            )
                        )
                    }
                }
            )
        )
    }
}
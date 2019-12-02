package com.heisenbug.demo.utils

import java.io.File


fun getLatestFile(dir: String) : File {

    val files: MutableList<File> = File(dir).listFiles().toMutableList()
    files.sortByDescending { it.lastModified() }

    return files.first()
}


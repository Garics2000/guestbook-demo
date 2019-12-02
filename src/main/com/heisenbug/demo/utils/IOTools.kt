package com.heisenbug.demo.utils

import java.io.File


fun getLatestRecord(dir: String) : File {

    val files: MutableList<File> = File(dir).listFiles().toMutableList()
    files.filter { it.extension == "mp4"  }
    files.sortByDescending { it.lastModified() }

    return files.first()
}


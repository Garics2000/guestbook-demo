package com.heisenbug.demo.config

import java.io.*
import java.util.Properties

object Configuration {

    var properties: Properties? = null

    init {
        load()
    }

    @Throws(IOException::class)
    fun load() {
        properties = Properties()
        val fis = FileInputStream(File("config.properties"))
        properties!!.load(fis)
    }

    operator fun get(option: String): String {
        return properties!!.getProperty(option) ?: return ""
    }
}
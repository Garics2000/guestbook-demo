package com.heisenbug.demo.utils

class MetadataPublisher(className: String) {

    val className: String = className

    fun publishScreenshot(testName: String) {
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.$className.$testName' type='image' value='metadata/screenshots/$testName.png' name='$testName.png']")
    }

    fun publishVideo(testName: String) {
        val filename = getLatestFile("video").name
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.$className.$testName' type='video' value='metadata/videos/${filename}' name='${filename}']")
    }
}
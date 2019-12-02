package com.heisenbug.demo.utils

class MetadataPublisher(testName: String) {

    val testName: String = testName

    public fun publishScreenshot(filename: String) {
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.${testName}.${filename}' type='image' value='metadata/screenshots/${filename}.png' name='${filename}']")
    }

    public fun publishVideo() {
        val filename = getLatestFile("video").name
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.${testName}.${filename}' type='video' value='metadata/videos/${filename}' name='${filename}']")
    }
}
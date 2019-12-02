package com.heisenbug.demo.utils

class MetadataPublisher(testName: String) {

    val testName: String = testName

    public fun publishScreenshot(filename: String) {
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.${testName}.${filename}' type='image' value='${filename}.png' name='${filename}']")
    }

    public fun publishVideo() {
        val filename = getLatestFile("video")
        print ("##teamcity[testMetadata testName='com.heisenbug.demo.${testName}.${filename}' type='video' value='${filename}' name='${filename}']")
    }
}
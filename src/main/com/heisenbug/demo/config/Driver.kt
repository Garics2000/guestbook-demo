package com.heisenbug.demo.config

import com.heisenbug.demo.config.Configuration as CoreConfiguration
import com.codeborne.selenide.Configuration

object Driver {

    // Setting up Selenide to use remote Selenoid's hub
    fun setUp(browser: String, version: String, enableVnc: Boolean = true, enableVideo: Boolean = false) {
        val hubUrl = CoreConfiguration["hub_url"]
        Configuration.driverManagerEnabled = false
        Configuration.remote = hubUrl
        Configuration.browser = browser
        Configuration.browserCapabilities.setBrowserName(browser)
        Configuration.browserCapabilities.setVersion(version)
        Configuration.browserCapabilities.setCapability("enableVNC", enableVnc)
        Configuration.browserCapabilities.setCapability("enableVideo", enableVideo)
    }

    fun tearDown() {
        Configuration.remote = null
    }
}
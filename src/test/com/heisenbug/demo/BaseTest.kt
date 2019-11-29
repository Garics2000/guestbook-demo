package com.heisenbug.demo

import com.codeborne.selenide.junit.TextReport
import com.codeborne.selenide.logevents.SelenideLogger.addListener
import com.codeborne.selenide.logevents.SelenideLogger.removeListener
import com.heisenbug.demo.config.Configuration
import com.heisenbug.demo.config.Driver
import io.qameta.allure.Allure.step
import io.qameta.allure.selenide.AllureSelenide
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.rules.TestRule

abstract class BaseTest {
    @Rule
    @JvmField
    var report: TestRule = TextReport().onFailedTest(true).onSucceededTest(true)

    companion object {
        val browser = Configuration["browser_name"]
        val version = Configuration["browser_version"]

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            Driver.setUp(browser, version)
            addListener("allure", AllureSelenide())
            addListener("AllureSelenide",
                AllureSelenide().screenshots(true).savePageSource(false))
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            Driver.tearDown()
            removeListener<AllureSelenide>("allure")
        }

    }
}
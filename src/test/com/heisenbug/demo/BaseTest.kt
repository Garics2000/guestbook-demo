package com.heisenbug.demo

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.screenshot
import com.codeborne.selenide.junit.ScreenShooter
import com.codeborne.selenide.junit.TextReport
import com.codeborne.selenide.logevents.SelenideLogger.addListener
import com.codeborne.selenide.logevents.SelenideLogger.removeListener
import com.heisenbug.demo.config.Configuration
import com.heisenbug.demo.config.Driver
import com.heisenbug.demo.utils.MetadataPublisher

import io.qameta.allure.selenide.AllureSelenide
import org.junit.rules.TestRule
import org.junit.*
import org.junit.rules.TestName


abstract class BaseTest {
    @Rule
    @JvmField
    var report: TestRule = TextReport().onFailedTest(true).onSucceededTest(true)

    @Rule
    @JvmField
    var name = TestName()
    //@Rule
    //@JvmField
    //var screenshots: TestRule = ScreenShooter.failedTests().succeededTests()

    companion object {
        val browser = Configuration["browser_name"]
        val version = Configuration["browser_version"]

        @BeforeClass
        @JvmStatic
        fun beforeClass() {

            addListener("allure", AllureSelenide())
            addListener("AllureSelenide",
                AllureSelenide().screenshots(true).savePageSource(false))
        }

        @AfterClass
        @JvmStatic
        fun afterClass() {
            removeListener<AllureSelenide>("allure")
        }

    }

    @Before
    fun beforeTest() {
        Driver.setUp(browser, version)
    }

    @After
    fun afterTest() {
        val filename = name.methodName
        screenshot(filename)

        Selenide.close()
        Driver.tearDown()

        val publisher = MetadataPublisher("MainPageTest")

        publisher.publishScreenshot(filename)
        publisher.publishVideo()
    }

}
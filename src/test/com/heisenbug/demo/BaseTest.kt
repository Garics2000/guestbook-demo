package com.heisenbug.demo

import com.codeborne.selenide.Selenide.screenshot
import com.codeborne.selenide.junit.ScreenShooter
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
import com.codeborne.selenide.junit.ScreenShooter.failedTests
import org.junit.After
import java.time.Instant
import org.junit.rules.TestName
import java.time.format.DateTimeFormatter


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

    @After
    fun afterTest() {
        //val filename = Instant.now().toString()
        val filename = name.methodName
        screenshot(filename)
        publishScreenshot(filename)
    }

    private fun publishScreenshot(filename: String) {

        print ("##teamcity[testMetadata testName='com.heisenbug.demo.MainPageTest.${name.methodName}' type='image' value='build/reports/tests/${filename}.png' name='${name.methodName}' timestamp='${DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(Instant.now())}']")
    }
}
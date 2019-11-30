package com.heisenbug.demo.pages

import com.heisenbug.demo.config.Configuration
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

open class Page {

    private val baseUrl = Configuration["base_url"]

    fun navigate() {
        Selenide.open(baseUrl)
    }

    protected fun s(locator: String): SelenideElement {
        return Selenide.`$`(locator)
    }

    protected fun s(locator: By): SelenideElement {
        return Selenide.`$`(locator)
    }

    protected fun ss(locator: String): ElementsCollection {
        return Selenide.`$$`(locator)
    }

    protected fun ss(locator: By): ElementsCollection {
        return Selenide.`$$`(locator)
    }
}
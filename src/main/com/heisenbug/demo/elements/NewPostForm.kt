package com.heisenbug.demo.elements

import com.codeborne.selenide.ElementsContainer
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

import org.openqa.selenium.support.FindBy

class NewPostForm : ElementsContainer() {

    @FindBy(name = "name")
    private lateinit var name: SelenideElement

    @FindBy(name = "imageUrl")
    private lateinit var imageUrl: SelenideElement

    @FindBy(name = "message")
    private lateinit var message: SelenideElement

    @FindBy(css = "[type='submit']")
    private lateinit var submit: SelenideElement

    fun submitPost(name: String, imageUrl: String, message: String) {
        this.name.sendKeys(name)
        this.imageUrl.sendKeys(imageUrl)
        this.message.sendKeys(message)
        this.submit.click()
    }
}
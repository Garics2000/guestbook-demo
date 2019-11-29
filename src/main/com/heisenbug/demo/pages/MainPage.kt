package com.heisenbug.demo.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.SelenideElement
import com.heisenbug.demo.elements.NewPostForm
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy


class MainPage : Page() {

     @FindBy(name = "name")
     private lateinit var name: SelenideElement

     @FindBy(name = "imageUrl")
     private lateinit var imageUrl: SelenideElement

     @FindBy(name = "message")
     private lateinit var message: SelenideElement

     @FindBy(css = "[type='submit']")
     private lateinit var submit: SelenideElement

     @FindBy(css = "[button]")
     private lateinit var button: SelenideElement

     var posts : ElementsCollection = ss("[class*='Message__messageImageContainer']")

     fun submitPost(name: String, imageUrl: String, message: String) {
          this.button.click()
          this.name.sendKeys(name)
          this.imageUrl.sendKeys(imageUrl)
          this.message.sendKeys(message)
          this.submit.click()
     }



     fun openForm() {
          s("button").click()
     }
}
package com.heisenbug.demo.pages

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.appears
import com.codeborne.selenide.Condition.visible


import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.executeJavaScript
import com.codeborne.selenide.SelenideElement
import com.codeborne.selenide.impl.Html.text
import com.heisenbug.demo.elements.NewPostForm
import com.sun.tools.javac.Main
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.FindBy


class MainPage : Page() {

     private var posts : ElementsCollection = ss(By.cssSelector("[class*='Message__messageImageContainer']"))
     private var authors: ElementsCollection = ss(By.cssSelector("[class*='Message__author']"))
     private var timeLabels: ElementsCollection = ss(By.cssSelector("[class*='Message__info'] span:nth-child(2)"))
     private var messages: ElementsCollection = ss(By.cssSelector("[class*='Message__text']"))
     private var errorMessages: ElementsCollection = ss(By.cssSelector("[class*='errorText']"))

     fun submitForm(name: String, imageUrl: String, message: String) {

          s("button").click()
          s(By.name("name")).sendKeys(name)
          s(By.name("message")).sendKeys(message)
          s(By.name("imageUrl")).click()
          //executeJavaScript<Unit>("document.getElementsByName('imageUrl')[0].setAttribute('value', '${imageUrl}');")
          s(By.name("imageUrl")).sendKeys(imageUrl)
          //s(By.name("imageUrl")).pressEnter()
          //executeJavaScript("document.getElementById('idelem').setAttribute('value','value');")
          s(By.cssSelector("[class*='GuestbookForm__image']")).waitUntil(appears, 10000)
          s("button[type='submit']").click()

          this.timeLabels.get(0).waitUntil(Condition.text("a few seconds ago"), 10000)
     }

     fun submitForm(name: String, message: String) {

          s("button").click()
          s(By.name("name")).sendKeys(name)
          s(By.name("message")).sendKeys(message)
          s("button[type='submit']").click()
     }

     fun getAllPostsNum() : Int{
          return this.posts.size
     }

     fun getLastAuthor() : String {
          return this.authors.first().text()
     }

     fun getLastMessage() : String {
          return this.messages.first().text()
     }

     fun getErrorMessage(index: Int) : String {
          return this.errorMessages.get(index).text()
     }

}
package com.heisenbug.demo.elements

import com.codeborne.selenide.ElementsContainer
import org.openqa.selenium.support.FindBy

class PostsList : ElementsContainer() {

    lateinit var items: List<Post>

    @FindBy(css = "[class*='Message__messageImageContainer']")
    class Post : ElementsContainer() {
    }
}
package com.heisenbug.demo

import com.heisenbug.demo.pages.MainPage
import io.qameta.allure.Description
import org.assertj.core.api.SoftAssertions
import org.junit.Test

class MainPageTest : BaseTest() {

    @Test
    @Description("Main page demo test positive")
    fun `Add a post`() {
        //val imgUrl = "https://images.unsplash.com/photo-1500100586562-f75ff6540087?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=400&q=80"
        val imgUrl = "https://raw.githubusercontent.com/openimages/dataset/master/assets/label-frequencies-total.png"
        val mainPage = MainPage()
        mainPage.navigate()

        //val numBefore = mainPage.getAllPostsNum()

        mainPage.submitForm("John Moore", imgUrl, "Test message")

        SoftAssertions.assertSoftly { softAssert ->
            softAssert.assertThat(mainPage.getLastAuthor()).`as`("Last post author title").contains("John Moore")
            softAssert.assertThat(mainPage.getLastMessage()).`as`("Last post message text").isEqualTo("Test message")
        }
    }

    @Test
    @Description("Main page demo test negative")
    fun `Post without image can't be added`() {
        val mainPage = MainPage()
        mainPage.navigate()

        mainPage.submitForm("John Moore", "Test message")

        SoftAssertions.assertSoftly { softAssert ->
            softAssert.assertThat(mainPage.getErrorMessage(1)).`as`("Submit error message").isEqualTo("Could not load the image")
        }
    }
}
package com.heisenbug.demo

import com.heisenbug.demo.pages.MainPage
import io.qameta.allure.Description
import org.assertj.core.api.SoftAssertions
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MainPageTest : BaseTest() {

    @Test
    @Description("Main page demo test")
    fun `Add a record with image`() {
        val imgUrl = "https://images.unsplash.com/photo-1500100586562-f75ff6540087?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3289&q=80"
        var mainPage = MainPage()
        mainPage.navigate()

        //mainPage.openForm()

        var numBefore = mainPage.posts.size

        //mainPage.newPostForm.submitPost("Hello2", imgUrl, "Test2")

        val test = 4
//        //mainPage.submitPost("Hello", imgUrl, "Test")
//
//
//        val numAfter = mainPage.posts.size
//        SoftAssertions.assertSoftly { softAssert ->
//            //softAssert.assertThat(mainPage.posts.size).`as`("Post number after tests").isEqualTo(numBefore + 1)
//        }
    }
}
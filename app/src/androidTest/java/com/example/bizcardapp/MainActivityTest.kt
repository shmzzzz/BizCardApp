package com.example.bizcardapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    // Activityが必要なので、createAndroidComposeRuleでActivityを指定する
    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun test_CreateInfoの表示() {
        composeTestRule.onNodeWithText("Miles P.").assertIsDisplayed()
        composeTestRule.onNodeWithText("Android Compose Programmer").assertIsDisplayed()
        composeTestRule.onNodeWithText("@themilesCompose").assertIsDisplayed()
    }

    @Test
    fun test_プロフィール画像の表示() {
        composeTestRule.onNodeWithContentDescription("profile image").assertIsDisplayed()
    }

    @Test
    fun test_Portfolioボタン表示時() {
        composeTestRule.onNodeWithText("Portfolio").assertIsDisplayed()
        // ボタンをクリックする前は、プロジェクトが表示されていないことを確認
        composeTestRule.onNodeWithText("Project 1").assertDoesNotExist()
    }

    @Test
    fun test_Portfolio表示時() {
        composeTestRule.onNodeWithText("Portfolio").performClick()

        // プロジェクトが表示されていることを確認する
        composeTestRule.onAllNodesWithText("Project 1")
        composeTestRule.onAllNodesWithText("Project 2")
        composeTestRule.onAllNodesWithText("Project 3")
        composeTestRule.onAllNodesWithText("Project 4")
        composeTestRule.onAllNodesWithText("Project 5")
    }


}

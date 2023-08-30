package com.ticma.curso.android.matchmatic

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testMainActivity() {
        Espresso.onView(
            ViewMatchers.withId(R.id.textToCompare)
        ).perform(ViewActions.typeText("Hola"))

        Espresso.onView(
            ViewMatchers.withId(R.id.textToCompare2)
        ).perform(ViewActions.typeText("Hola"))

        Espresso.onView(
            ViewMatchers.withId(R.id.button)
        ).perform(ViewActions.click())

    }
}
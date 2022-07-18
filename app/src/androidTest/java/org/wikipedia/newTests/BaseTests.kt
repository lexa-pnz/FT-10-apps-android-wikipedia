package org.wikipedia.newTests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.core.AllOf
import org.wikipedia.newTests.customMatchers.GetTextHintColor.Companion.hasTextHintColor

class BaseTests {

    companion object {

        fun typeTextInTheField(resourceId: Int, text: String){
            onView(
                AllOf.allOf(
                    supportsInputMethods(),
                    isDescendantOfA(withId(resourceId))
                )
            ).perform(
                ViewActions.typeText(text),
                ViewActions.closeSoftKeyboard()
            )
        }

        fun checkTextInTheField(resourceId: Int, text: String){

            onView(
                AllOf.allOf(
                    supportsInputMethods(),
                    isDescendantOfA(withId(resourceId))
                )
            ).check(
                matches(
                    withText(text)
                )
            )
        }


        fun clickElementById(resourceId: Int) {
            onView(withId(resourceId))
                .perform(ViewActions.click())
        }

        fun clickElementByText(resourceId: Int) {
            onView(withText(resourceId))
                .perform(ViewActions.click())
        }

        fun clickElementById(resourceIdChildElement: Int, resourceIdParentElement: Int) {
            onView(
                AllOf.allOf(
                    withId(resourceIdChildElement),
                    isDescendantOfA(withId(resourceIdParentElement))
                )
            ).perform(ViewActions.click())
        }

        fun checkDisplayedElementById(resourceId: Int) {
            onView(withId(resourceId))
                .check(matches(isDisplayed()))
        }

        fun checkDisplayedElementByText(resourceId: Int) {
            onView(withText(resourceId))
                .check(matches(isDisplayed()))
        }

        fun checkDisplayedTextElementById(resourceId: Int, text: String) {
            onView(withId(resourceId))
                .check(matches(withText(text)))
        }

        fun checkDisplayedTextElementById(resourceIdChildElement: Int, resourceIdParentElement: Int, text: Int) {
            onView(
                AllOf.allOf(
                    withId(resourceIdChildElement),
                    isDescendantOfA(withId(resourceIdParentElement))
                )
            )
                .check(matches(withText(text)))
        }

        fun checkDisplayedTextElementById(resourceId: Int, text: Int) {
            onView(withId(resourceId))
                .check(matches(withText(text)))
        }

        fun checkDisplayedTextElementByText(resourceId: Int, text: Int) {
            onView(withText(resourceId))
                .check(matches(withText(text)))
        }

        fun checkDisplayedTextElementByText(resourceId: Int, text: String) {
            onView(withText(resourceId))
                .check(matches(withText(text)))
        }

        fun checkColorElement(resourceIdChildElement: Int, resourceIdParentElement: Int, color: Int){
            onView(
                AllOf.allOf(
                    withId(resourceIdChildElement),
                    isDescendantOfA(withId(resourceIdParentElement))
                )
            ).check(matches(hasTextColor(color)))
        }

        fun checkColorHint(resourceId: Int, color: Int){
            onView(
                AllOf.allOf(
                    supportsInputMethods(),
                    isDescendantOfA(withId(resourceId)),
                    hasTextHintColor(resourceId)
                )
            ).check(matches(hasTextColor(color)))
        }

    }
}
package org.wikipedia.newTests.customMatchers

import android.view.View
import android.widget.TextView
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Description

class GetTextHintColor {

    companion object {

        fun hasTextHintColor(colorResId: Int): BoundedMatcher<View?, TextView> {
            return object : BoundedMatcher<View?, TextView>(TextView::class.java){

                override fun describeTo(description: Description) {
                    var colorId = colorResId.toString()
                    if (InstrumentationRegistry.getInstrumentation().targetContext != null) {
                        colorId = InstrumentationRegistry.getInstrumentation().targetContext.resources.getResourceName(colorResId)
                    }
                    description.appendText("has color with ID $colorId")
                }

                override fun matchesSafely(textView: TextView): Boolean {
                    val textViewColor = textView.currentHintTextColor
                    val expectedColor: Int
                    expectedColor = InstrumentationRegistry.getInstrumentation().targetContext.getColor(colorResId)
                    return textViewColor == expectedColor
                }
            }
        }
    }

}
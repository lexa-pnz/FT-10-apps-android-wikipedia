package org.wikipedia.newTests.pages

import org.wikipedia.R
import org.wikipedia.newTests.BaseTests.Companion.clickElementById

class StartOnboardingPage {

    private val skipBtn = R.id.fragment_onboarding_skip_button

    fun clickSkipBtn() {

        clickElementById(skipBtn)
    }

    companion object {

        inline operator fun invoke(block: StartOnboardingPage.() -> Unit) = StartOnboardingPage().block()
    }

}
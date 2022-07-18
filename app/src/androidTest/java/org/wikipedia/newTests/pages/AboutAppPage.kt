package org.wikipedia.newTests.pages

import org.wikipedia.R
import org.wikipedia.newTests.BaseTests.Companion.checkDisplayedElementById
import org.wikipedia.newTests.BaseTests.Companion.checkDisplayedElementByText
import org.wikipedia.newTests.BaseTests.Companion.checkDisplayedTextElementById

class AboutAppPage() {

    private val aboutPageId = R.id.about_container

    private val getContributorsHeadingText = R.string.about_contributors_heading
    private val getContributorsBodyTextAndUrl = R.string.about_contributors
    private val getContributorsBodyText = "Team page"
    private val getContributorsBodyId = R.id.about_contributors

    private val getTranslatorsHeadingText = R.string.about_translators_heading
    private val getTranslatorsBodyTextAndUrl = R.string.about_translators_translatewiki
    private val getTranslatorsBodyText =
        "This app was translated by the volunteer translators at translatewiki.net."
    private val getTranslatorsBodyId = R.id.about_translators

    private val getLicenseHeadingText = R.string.about_app_license_heading
    private val getLicenseBodyTextAndUrl = R.string.about_app_license
    private val getLicenseBodyText =
        "Source code available on Gerrit and GitHub under the Apache 2.0 License. Unless otherwise specified, content is available under a Creative Commons Attribution-ShareAlike License."
    private val getLicenseBodyId = R.id.about_app_license

    // Open page

    fun checkOpenAboutApPage() {
        checkDisplayedElementById(aboutPageId)
    }

    // check Contributors

    fun checkContributorsHeading() {
        checkDisplayedElementByText(getContributorsHeadingText)
    }

    fun checkDisplayedContributorsBody() {
        checkDisplayedElementById(getContributorsBodyId)
    }

    fun checkTextContributorsBody() {
        checkDisplayedTextElementById(getContributorsBodyId, getContributorsBodyText)
    }

    // check Translators

    fun checkTranslatorsHeading() {
        checkDisplayedElementByText(getTranslatorsHeadingText)
    }

    fun checkDisplayedTranslatorsBody() {
        checkDisplayedElementById(getTranslatorsBodyId)
    }

    fun checkTextTranslatorsBody() {
        checkDisplayedTextElementById(getTranslatorsBodyId, getTranslatorsBodyText)
    }

    // check License

    fun checkLicenseHeading() {
        checkDisplayedElementByText(getLicenseHeadingText)
    }

    fun checkDisplayedLicenseBody() {
        checkDisplayedElementById(getLicenseBodyId)
    }

    fun checkTextLicenseBody() {
        checkDisplayedTextElementById(getLicenseBodyId, getLicenseBodyText)
    }

    companion object {

        inline operator fun invoke(block: AboutAppPage.() -> Unit) = AboutAppPage().block()
    }

}
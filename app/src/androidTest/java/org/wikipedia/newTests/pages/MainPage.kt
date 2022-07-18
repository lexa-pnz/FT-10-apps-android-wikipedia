package org.wikipedia.newTests.pages

import org.wikipedia.R
import org.wikipedia.newTests.BaseTests.Companion.clickElementById

class MainPage {


    private val moreBtn = R.id.nav_more_container

    fun clickMoreBtn() {

        clickElementById(moreBtn)
    }

    companion object {

        inline operator fun invoke(block: MainPage.() -> Unit) = MainPage().block()
    }

}
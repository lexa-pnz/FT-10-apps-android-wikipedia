package org.wikipedia.newTests.pages

import org.wikipedia.R
import org.wikipedia.newTests.BaseTests.Companion.clickElementById

class MoreBottomShit {


    private val loginBtn = R.id.main_drawer_login_button

    fun clickLoginBtn() {

        clickElementById(loginBtn)
    }

    companion object {

        inline operator fun invoke(block: MoreBottomShit.() -> Unit) = MoreBottomShit().block()
    }

}
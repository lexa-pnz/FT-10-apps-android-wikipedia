package org.wikipedia.newTests.pages

import org.wikipedia.R
import org.wikipedia.newTests.BaseTests.Companion.checkColorElement
import org.wikipedia.newTests.BaseTests.Companion.checkDisplayedTextElementById
import org.wikipedia.newTests.BaseTests.Companion.checkTextInTheField
import org.wikipedia.newTests.BaseTests.Companion.clickElementById
import org.wikipedia.newTests.BaseTests.Companion.typeTextInTheField

class CreateAnAccountPage {

    // Test data
    private val login = "NewUser1111"
    private val passwordOpen = "1234567"
    private val passwordHidden = "•••••••"

    // Login Field
    private val loginFieldId = R.id.create_account_username

    // Password Field
    private val passwordFieldId = R.id.create_account_password_input

    // Eye Buttons
    private val eyeBtnStartId = R.id.text_input_start_icon
    private val eyeBtnEndId = R.id.text_input_end_icon
    private val eyeBtnErrId = R.id.text_input_error_icon

    // Next Button
    private val nextBtnId = R.id.create_account_submit_button

    // Input error field
    private val textInputError = R.id.textinput_error
    private val createAccountPasswordErr = R.string.create_account_password_error

    // Colors
    private val colorRed = R.color.red50

    fun typingTextInFieldLogin() {

        typeTextInTheField(loginFieldId, login)
    }

    fun typingTextInFieldPassword() {

        typeTextInTheField(passwordFieldId, passwordOpen)
    }

    fun checkingHiddenPassword() {

        checkTextInTheField(passwordFieldId, passwordHidden)
    }

    fun checkingOpenPassword() {

        checkTextInTheField(passwordFieldId, passwordOpen)
    }

    fun clickBtnEye() {

        clickElementById(eyeBtnEndId, passwordFieldId)
    }

    fun clickBtnNext() {

        clickElementById(nextBtnId)
    }

    fun checkTextPasswordErrMassage() {

        checkDisplayedTextElementById(
            textInputError,
            passwordFieldId,
            createAccountPasswordErr
        )
    }

    fun checkTextColorPasswordErrMassage() {

        checkColorElement(
            textInputError,
            passwordFieldId,
            colorRed
        )
    }

    fun checkColorHintPasswordField() {

        // checkColorHint(PASSWORD_FIELD_ID, COLOR_RED)
    }

    companion object {

        inline operator fun invoke(block: CreateAnAccountPage.() -> Unit) = CreateAnAccountPage().block()
    }

}
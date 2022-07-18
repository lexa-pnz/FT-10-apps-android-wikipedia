package org.wikipedia.newTests.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.main.MainActivity
import org.wikipedia.newTests.pages.CreateAnAccountPage
import org.wikipedia.newTests.pages.MainPage
import org.wikipedia.newTests.pages.MoreBottomShit
import org.wikipedia.newTests.pages.StartOnboardingPage


@RunWith(AllureAndroidJUnit4::class)
@DisplayName("Валидация пароля")
class CheckingValidationPassword {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun goToCreateAccountPage(){

        Allure.step("Шаг 1. Страница 'Создание аккаунта'") {
            StartOnboardingPage {
                clickSkipBtn()
            }

            MainPage {
                clickMoreBtn()
            }

            MoreBottomShit {
                clickLoginBtn()
            }
        }
    }

    @Test
    @DisplayName("Проверка на минимальную длину пароля")
    fun checkMinimumLength(){
        CreateAnAccountPage {

            Allure.step("Шаг 2. Ввод текста в поле 'Логин'") {
                typingTextInFieldLogin()
            }

            Allure.step("Шаг 3. Ввод текста в поле 'Пароль'") {
                typingTextInFieldPassword()
            }

            Allure.step("Шаг 4. Нажатие кнопки 'Далее'") {
                clickBtnNext()
            }

            Allure.step("Шаг 5. Проверка цвета хинта поля 'Пароль'") {
                checkColorHintPasswordField() // ---
            }

            Allure.step("Шаг 6. Проверка текста ошибки о минимальной длине пароля") {
                checkTextPasswordErrMassage()
            }

            Allure.step("Шаг 7. Проверка цвета ошибки о минимальной длине пароля") {
                checkTextColorPasswordErrMassage()
            }
        }
    }

}
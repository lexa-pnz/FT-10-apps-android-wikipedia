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
@DisplayName("Проверка отображения и скрытия пароля")
class CheckingPasswordHiding {

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
    @DisplayName("Тест на дефолтное отображение пароля")
    fun passwordIsHiddenDef(){

        CreateAnAccountPage {

            Allure.step("Шаг 2. Ввод текста в поле 'Пароль'") {
                typingTextInFieldPassword()
            }

            Allure.step("Шаг 3. Пароль скрыт'") {
                checkingHiddenPassword()
            }
        }
    }

    @Test
    @DisplayName("Тест показа пароля")
    fun passwordIsNotHidden(){

        CreateAnAccountPage {

            Allure.step("Шаг 2. Ввод текста в поле 'Пароль'") {
                typingTextInFieldPassword()
            }

            Allure.step("Шаг 2. Клик на кнопку скрытия пароля") {
                clickBtnEye()
            }

            Allure.step("Шаг 3. Пароль не скрыт'") {
                checkingOpenPassword()
            }
        }
    }

    @Test
    @DisplayName("Тест скрытия пароля")
    fun passwordIsHidden(){

        CreateAnAccountPage {

            Allure.step("Шаг 2. Ввод текста в поле 'Пароль'") {
                typingTextInFieldPassword()
            }

            Allure.step("Шаг 3. Клик на кнопку скрытия пароля") {
                clickBtnEye()
            }

            Allure.step("Шаг 4. Клик на кнопку показа пароля") {
                clickBtnEye()
            }

            Allure.step("Шаг 5. Пароль скрыт") {
                checkingHiddenPassword()
            }
        }
    }

}
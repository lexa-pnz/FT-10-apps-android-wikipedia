package org.wikipedia.newTests.tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.Allure.step
import io.qameta.allure.kotlin.junit4.DisplayName
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.wikipedia.newTests.pages.AboutAppPage
import org.wikipedia.settings.AboutActivity


@RunWith(AllureAndroidJUnit4::class)
@DisplayName("Проверка блоков на экране 'О Приложении'")
class CheckingBlocksOnAboutScreen {

    @get:Rule
    val activityRule = ActivityScenarioRule(AboutActivity::class.java)

    @Before
    fun checkActivity(){

        AboutAppPage {
            step("Шаг 1. Страница 'О Приложении'") {
                checkOpenAboutApPage()
            }
        }
    }

    @Test
    @DisplayName("Тест блока 'Разработчики'")
    fun checkBlockContributorsTest(){

        AboutAppPage {
            step("Шаг 2. Проверка заголовка") {
                checkContributorsHeading()
            }

            step("Шаг 3. Проверка данных о разработчиках") {
                checkDisplayedContributorsBody()
                checkTextContributorsBody()
            }

        }
    }

    @Test
    @DisplayName("Тест блока 'Переводчики'")
    fun checkBlockTranslatorsTest(){

        AboutAppPage {

            step("Шаг 2. Проверка заголовка") {
                checkTranslatorsHeading()
            }

            step("Шаг 3. Проверка данных о переводчиках") {
                checkDisplayedTranslatorsBody()
                checkTextTranslatorsBody()
            }
        }

    }

    @Test
    @DisplayName("Тест блока 'Лицензия'")
    fun checkBlockLicenseTest(){

        AboutAppPage {

            step("Шаг 2. Проверка заголовка") {
                checkLicenseHeading()
            }

            step("Шаг 3. Проверка данных о лицензтт") {
                checkDisplayedLicenseBody()
                checkTextLicenseBody()
            }
        }

    }

}

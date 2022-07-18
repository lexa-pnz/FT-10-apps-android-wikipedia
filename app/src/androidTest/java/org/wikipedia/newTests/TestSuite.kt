package org.wikipedia.newTests

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.newTests.tests.CheckingBlocksOnAboutScreen
import org.wikipedia.newTests.tests.CheckingPasswordHiding
import org.wikipedia.newTests.tests.CheckingValidationPassword

@RunWith(Suite::class)
@Suite.SuiteClasses(
    CheckingBlocksOnAboutScreen::class,
    CheckingPasswordHiding::class,
    CheckingValidationPassword::class
)
class TestSuite
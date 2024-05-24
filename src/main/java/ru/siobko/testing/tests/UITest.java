package ru.siobko.testing.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.models.TestBot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class UITest {

    protected static final String BROWSER = "chrome";
    protected static final String BASE_URL = "https://ok.ru";

    protected static final TestBot BOT1 = new TestBot("technopol72", "technopolisPassword");
    protected static final TestBot BOT2 = new TestBot("technopol54", "technopolisPassword");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.baseUrl = BASE_URL;
        clearBrowserCache();
        Selenide.open("/");
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}

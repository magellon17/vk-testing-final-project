package ru.siobko.testing.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.models.TestBot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class BaseTest {

    protected static final String BROWSER = "chrome";
    protected static final String BASE_URL = "https://ok.ru";

    protected static final TestBot BOT = new TestBot("technopol72", "technopolisPassword");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.baseUrl = BASE_URL;
        Selenide.open("/");
        clearBrowserCache();
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}

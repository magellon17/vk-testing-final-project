package ru.siobko.testing.tests;

import com.codeborne.selenide.*;
import com.codeborne.selenide.impl.SelenideElementDescriber;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.siobko.testing.models.TestBot;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class UITest {

    protected static final String BROWSER = "chrome";
    protected static final String BASE_URL = "https://ok.ru";

    protected static final TestBot MAIN_BOT = new TestBot("technopol72", "technopolisPassword");
    protected static final TestBot EXTRA_BOT = new TestBot("technopol54", "technopolisPassword");

    @BeforeAll
    public static void setUp() {
        Configuration.browser = BROWSER;
        Configuration.baseUrl = BASE_URL;
        System.setProperty("chromeoptions.prefs","intl.accept_languages=ru");
        clearBrowserCache();
        Selenide.open("/");
    }

    @AfterAll
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}

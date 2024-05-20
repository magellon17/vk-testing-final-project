package ru.siobko.testing.core.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Меню навигации в левой колонке с разделами
 */
public class SideNavigationBlock {

    private static final Logger log = LoggerFactory.getLogger(SideNavigationBlock.class);

    private static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    private static final By HOME_BUTTON = byXpath(".//a[@data-l='t,userMain']");

    public void clickOnHome() {
        log.info("Кликаем на ленту");
        $(HOME_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода на ленту")
        ).click();
    }

    public void clickOnMyProfile() {
        log.info("Кликаем на мой профиль");
        $(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль")
        ).click();
    }
}

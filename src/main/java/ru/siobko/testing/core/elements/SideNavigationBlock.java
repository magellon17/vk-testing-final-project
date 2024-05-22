package ru.siobko.testing.core.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Меню навигации в левой колонке с разделами
 */
public class SideNavigationBlock {

    private static final Logger log = LoggerFactory.getLogger(SideNavigationBlock.class);

    private final SelenideElement block = $(byId("hook_Block_SideNavigation"));

    private static final By MY_PROFILE_BUTTON = byXpath(".//a[@data-l='t,userPage']");
    private static final By HOME_BUTTON = byText("Лента");
    private static final By FRIENDS_BUTTON = byText("Друзья");

    public void clickOnHome() {
        log.info("Кликаем на кнопку 'Лента'");
        block.$(HOME_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода на ленту")
        ).click();
    }

    public void clickOnMyProfile() {
        log.info("Кликаем на мой профиль");
        block.$(MY_PROFILE_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода в профиль")
        ).click();
    }

    public void clickOnFriends() {
        log.info("Кликаем на кнопку 'Друзья'");
        block.$(FRIENDS_BUTTON).shouldBe(
                visible.because("Нет кнопки для перехода на страницу друзей")
        ).click();
    }
}

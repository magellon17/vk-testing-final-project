package ru.siobko.testing.core.elements.sideNavigation;

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

    private static final By MY_PROFILE_BTN = byXpath(".//a[@data-l='t,userPage']");
    private static final By HOME_BTN = byText("Лента");
    private static final By FRIENDS_BTN = byText("Друзья");
    private static final By HOBBY_BTN = byText("Увлечения");

    public void clickOnHome() {
        log.info("Кликаем на кнопку 'Лента'");
        block.$(HOME_BTN).shouldBe(
                visible.because("Нет кнопки для перехода на ленту")
        ).click();
    }

    public void clickOnMyProfile() {
        log.info("Кликаем на мой профиль");
        block.$(MY_PROFILE_BTN).shouldBe(
                visible.because("Нет кнопки для перехода в профиль")
        ).click();
    }

    public void clickOnFriends() {
        log.info("Кликаем на кнопку 'Друзья'");
        block.$(FRIENDS_BTN).shouldBe(
                visible.because("Нет кнопки для перехода на страницу друзей")
        ).click();
    }

    public void clickOnHobbies() {
        log.info("Кликаем на кнопку 'Увлечения'");
        block.$(HOBBY_BTN).shouldBe(
                visible.because("Нет кнопки для перехода на страницу увлечений")
        ).click();
    }
}

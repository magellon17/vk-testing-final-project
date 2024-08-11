package ru.siobko.testing.core.groupPage.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GroupNavigationMenu {

    private static final Logger log = LoggerFactory.getLogger(GroupNavigationMenu.class);

    private final SelenideElement navi = $(byXpath(".//*[@data-l='t,horizontalNavigation']"));

    private static final By MEMBERS_BUTTON = byText("Участники");
    private static final By PHOTOS_BUTTON = byText("Фото");
    private static final By FEED_BUTTON = byText("Лента");

    public void clickOnMembers() {
        log.info("Кликаем на участников");
        navi.$(MEMBERS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка участников")
        ).click();
    }

    public void clickOnPhotos() {
        log.info("Кликаем на фото");
        navi.$(PHOTOS_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка фоток")
        ).click();
    }

    public void clickOnFeed() {
        log.info("Кликаем на ленту");
        navi.$(FEED_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка ленты")
        ).click();
    }
}

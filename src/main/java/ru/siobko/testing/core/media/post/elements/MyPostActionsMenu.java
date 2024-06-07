package ru.siobko.testing.core.media.post.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Контектсное меню собственного поста
 */
public class MyPostActionsMenu {

    private static final Logger log = LoggerFactory.getLogger(MyPostActionsMenu.class);

    private static final By DELETE_POST_BTN = byXpath(".//*[contains(@hrefattrs, 'StatusLayer_deleteButton')]");

    public void clickOnDelete() {
        log.info("Кликаем на кнопку 'Удалить заметку'");
        executeJavaScript("arguments[0].click();", $(DELETE_POST_BTN));
    }
}

package ru.siobko.testing.core.media.post.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PostActionsMenu {

    private static final Logger log = LoggerFactory.getLogger(PostActionsMenu.class);

    private static final By DELETE_POST_BUTTON = byXpath(".//*[contains(@hrefattrs, 'StatusLayer_deleteButton')]");

    public void clickOnDelete() {
        log.info("Кликаем на кнопку 'Удалить заметку'");
        executeJavaScript("arguments[0].click();", $(DELETE_POST_BUTTON));
    }
}

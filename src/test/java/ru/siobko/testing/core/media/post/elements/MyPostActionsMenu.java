package ru.siobko.testing.core.media.post.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

/**
 * Контектсное меню собственного поста
 */
public class MyPostActionsMenu {

    private static final Logger log = LoggerFactory.getLogger(MyPostActionsMenu.class);

    private final SelenideElement menu = $(byId("hook_Block_ShortcutMenu"));

    private static final By DELETE_BTN = byText("Удалить заметку");
    private static final By DISABLE_COMMENTS_BTN = byText("Отключить комментирование");

    public void clickOnDeletePost() {
        log.info("Кликаем на кнопку 'Удалить заметку'");
        executeJavaScript("arguments[0].click();", menu.$(DELETE_BTN));
    }

    public void clickOnDisablePostComments() {
        log.info("Кликаем на кнопку 'Отключить комментирование'");
        executeJavaScript("arguments[0].click();", menu.$(DISABLE_COMMENTS_BTN));
    }
}

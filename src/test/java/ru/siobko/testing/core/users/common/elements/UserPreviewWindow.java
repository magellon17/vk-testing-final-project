package ru.siobko.testing.core.users.common.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

/**
 * Меню пользователя, которое раскрывается при наведении курсора на его username
 */
public class UserPreviewWindow implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(UserPreviewWindow.class);

    private final SelenideElement menu = $(byId("hook_Block_ShortcutMenu"));

    private static final By USERNAME = byXpath(".//*[contains(@hrefattrs, 'User_SM_Visit')]");
    private static final By MAKE_FRIEND_BTN = byText("Дружить");
    private static final By SENT_FRIEND_REQUEST_TITLE = byText("Запрос отправлен");

    public UserPreviewWindow(){
        check();
        log.info("Открылось контекстное меню пользователя");
    }

    @Override
    public void check() throws Error {
        menu.$(USERNAME).shouldBe(
                visible.because("Не отобразилось имя пользователя(гиперссылка)"));
    }

    public UserPreviewWindow clickOnMakeFriendshipButton() {
        menu.$(MAKE_FRIEND_BTN).shouldBe(
                visible.because("Не отобразилась кнопка 'Дружить'")
        ).click();
        return this;
    }

    public boolean isSentFriendRequestTitleDisplaying() {
        return menu.$(SENT_FRIEND_REQUEST_TITLE).shouldBe(
                visible.because("Не отобразился заголовок 'Запрос отправлен'")
        ).isDisplayed();
    }
}

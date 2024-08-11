package ru.siobko.testing.core.profilePage.otherProfile.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class FriendRelationsSelector implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(FriendRelationsSelector.class);

    private static final By REVOKE_FRIEND_REQUEST = byXpath(".//*[@aria-label='Отменить запрос']");

    public FriendRelationsSelector(){
        check();
        log.info("Открылось меню выбора дружеских отношений");
    }

    @Override
    public void check() throws Error {
        $(REVOKE_FRIEND_REQUEST).shouldBe(
                visible.because("Не отобразилась кнопка отмены запроса"));
    }

    public void clickOnRevokeFriendRequest() {
        log.info("Кликаем на кнопку 'Отменить запрос'");
        $(REVOKE_FRIEND_REQUEST).shouldBe(
                visible.because("Не отобразилась кнопка отмены запроса")
        ).click();
    }
}

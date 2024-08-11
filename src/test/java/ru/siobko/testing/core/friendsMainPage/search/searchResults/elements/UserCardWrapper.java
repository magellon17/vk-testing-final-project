package ru.siobko.testing.core.friendsMainPage.search.searchResults.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.profilePage.otherProfile.UserProfilePage;
import ru.siobko.testing.core.profilePage.common.elements.UserPreviewWindow;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;

/**
 * Обертка над карточкой пользователя на странице поисковой выдачи
 */
public class UserCardWrapper {

    private static final Logger log = LoggerFactory.getLogger(UserCardWrapper.class);

    private final SelenideElement card;

    private static final By SEND_FRIEND_REQUEST_BTN = By.xpath(".//*[contains(@href,'FriendSearch_add')]");
    private static final By SENT_FRIEND_REQUEST_BANNER = byText("Запрос отправлен");
    private static final By USERNAME = By.xpath(".//*[contains(@hrefattrs,'FriendSearch_name')]");

    public UserCardWrapper(SelenideElement card) {
        this.card = card;
    }

    public UserCardWrapper clickOnSendFriendRequest() {
        log.info("Кликаем на кнопку 'Добавить в друзья'");
        card.$(SEND_FRIEND_REQUEST_BTN).shouldBe(
                visible.because("Не отобразилась кнопка отправки заявки в друзья")
        ).click();
        return this;
    }

    public UserProfilePage clickOnUserName() {
        log.info("Кликаем на имя пользователя, т.е. гиперссылку");
        card.$(USERNAME).shouldBe(
                visible.because("Не отобразилось имя пользователя, т.е. гиперссылка")
        ).click();
        return new UserProfilePage();
    }

    public boolean isSentFriendRequestBannerDisplayed() {
        return card.$(SENT_FRIEND_REQUEST_BANNER).shouldBe(visible).isDisplayed();
    }

    public UserPreviewWindow expandUserPreviewWindowViaHoveringOnUsername() {
        card.$(USERNAME).shouldBe(
                visible.because("Не отобразилось имя пользователя")
        ).hover();
        return new UserPreviewWindow();
    }
}

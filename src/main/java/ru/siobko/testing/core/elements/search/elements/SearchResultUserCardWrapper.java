package ru.siobko.testing.core.elements.search.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.user.UserProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;

public class SearchResultUserCardWrapper {

    private static final Logger log = LoggerFactory.getLogger(SearchResultUserCardWrapper.class);

    private final SelenideElement card;

    private static final By SEND_FRIEND_REQUEST_BTN = byXpath(".//div[@class='card-right__lm5x7 card-right__a0i64 place-for-icon__mpodh']");
    private static final By SENT_FRIEND_REQUEST_BANNER = byText("Заявка отправлена");

    public SearchResultUserCardWrapper(SelenideElement card) {
        this.card = card;
    }

    public SearchResultUserCardWrapper clickOnSendFriendRequest() {
        log.info("Кликаем на иконку 'Добавить в друзья'");
        card.hover().$(SEND_FRIEND_REQUEST_BTN).shouldBe(
                visible.because("Не отобразилась кнопка отправки заявки в друзья")
        ).click();
        return this;
    }

    public UserProfilePage clickOnCard() {
        log.info("Кликаем на карточку пользователя");
        card.shouldBe(
                visible.because("Не нашлась карточка пользователя")
        ).click();
        return new UserProfilePage();
    }

    public boolean isSentFriendRequestBannerDisplayed() {
        return card.$(SENT_FRIEND_REQUEST_BANNER).shouldBe(visible).isDisplayed();
    }
}

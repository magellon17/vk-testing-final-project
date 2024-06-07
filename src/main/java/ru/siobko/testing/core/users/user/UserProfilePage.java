package ru.siobko.testing.core.users.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.users.common.CommonUserProfilePage;
import ru.siobko.testing.core.users.user.elements.FriendRelationsSelector;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

/**
 * Главная страница профиля пользователя
 */
public class UserProfilePage extends CommonUserProfilePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(UserProfilePage.class);

    private static final By SEND_MESSAGE_BTN = byXpath(".//*[contains(@hrefattrs,'FriendTopCardButtonsSendMessage')]");
    private static final By EXPAND_FRIEND_RELATIONS_SELECTOR = byXpath(".//*[@aria-label='Запрос отправлен']");

    public UserProfilePage() {
        check();
        log.info("Загрузилась страница профиля пользователя");
    }

    @Override
    public void check() throws Error {
        $(SEND_MESSAGE_BTN).shouldBe(
                visible.because("Не отобразилась кнопка отправки сообщения"));
    }

    public FriendRelationsSelector expandFriendRelationsSelector() {
        log.info("Раскрываем меню дружеский отношений");
        $(EXPAND_FRIEND_RELATIONS_SELECTOR).shouldBe(
                visible.because("Не отобразилась серая кнопка с надписью 'Запрос отправлен'")
        ).click();
        return new FriendRelationsSelector();
    }
}

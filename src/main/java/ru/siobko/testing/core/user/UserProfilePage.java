package ru.siobko.testing.core.user;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.SideNavigationBlock;
import ru.siobko.testing.core.home.HomePage;
import ru.siobko.testing.core.media.photo.PhotoLayer;
import ru.siobko.testing.core.user.elements.FriendRelationsSelector;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class UserProfilePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(UserProfilePage.class);

    protected final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    protected static final By OPEN_LATEST_USER_PHOTO = byXpath(".//*[@data-l='targetPosition,0']");

    private static final By SEND_MESSAGE_BUTTON = byXpath(".//*[contains(@hrefattrs,'FriendTopCardButtonsSendMessage')]");
    private static final By EXPAND_FRIEND_RELATIONS_SELECTOR = byXpath(".//*[@aria-label='Запрос отправлен']");

    public UserProfilePage() {
        check();
        log.info("Открылась страница профиля пользователя");
    }

    @Override
    public void check() throws Error {
        $(SEND_MESSAGE_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка отправки сообщения"));
    }

    public PhotoLayer openLatestPhoto() {
        log.info("Открываем последнее фото профиля");
        $(OPEN_LATEST_USER_PHOTO).shouldBe(
                visible.because("Не отобразилась кнопка настроек")
        ).click();
        return new PhotoLayer();
    }

    public HomePage openHomePage() {
        log.info("Переходим на страницу ленты");
        sideNavigationBlock.clickOnHome();
        return new HomePage();
    }

    public FriendRelationsSelector expandFriendRelationsSelector() {
        log.info("Раскрываем меню дружеский отношений");
        $(EXPAND_FRIEND_RELATIONS_SELECTOR).shouldBe(
                visible.because("Не отобразилась серая кнопка с надписью 'Запрос отправлен'")
        ).click();
        return new FriendRelationsSelector();
    }
}
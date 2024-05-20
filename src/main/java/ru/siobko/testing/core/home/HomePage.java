package ru.siobko.testing.core.home;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.SideNavigationBlock;
import ru.siobko.testing.core.home.elements.avatar.AvatarShortcutMenu;
import ru.siobko.testing.core.home.elements.avatar.PhotoPickerLayer;
import ru.siobko.testing.core.user.MyUserProfilePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By FEED_POST = byClassName("feed-w");
    private static final By HOBBIES_CONTAINER = byXpath(".//div[@data-l='t,hobbies.content']");
    private static final By UPLOAD_AVATAR_BUTTON = byClassName("lcTc_avatar_lk");
    private static final By AVATAR_BLOCK = byId("hook_Block_Avatar");
    private static final By EXPAND_AVATAR_MENU = byId("viewImageLinkId");

    public HomePage() {
        isLoaded();
        log.info("Перешли на главную страницу пользователя");
    }

    public void isLoaded() throws Error {
        $(FEED_POST).shouldBe(
                visible.because("Не отобразился первый пост ленты"));
        $(HOBBIES_CONTAINER).shouldBe(
                visible.because("Не отобразился блок увлечений ленты"));
        $(AVATAR_BLOCK).shouldBe(
                visible.because("Не отобразился блок аватара"));
    }

    public PhotoPickerLayer clikcOnAddAvatar() {
        log.info("Кликаем на 'Добавить фото' в кружочке аватара.");
        $(UPLOAD_AVATAR_BUTTON).shouldBe(
                visible.because("Не отобразилась кнопка добавки фото")
        ).click();
        return new PhotoPickerLayer();
    }

    public AvatarShortcutMenu expandAvatarShortcutMenu() {
        log.info("Раскрываем контекстное меню аватара");
        $(EXPAND_AVATAR_MENU).shouldBe(
                visible.because("Не загрузилась аватарка")
        ).hover();
        return new AvatarShortcutMenu();
    }

    public boolean checkUploadAvatarButtonIsDisplayed() {
        return $(UPLOAD_AVATAR_BUTTON).isDisplayed();
    }

    public MyUserProfilePage openProfilePage() {
        log.info("Переходим на страницу профиля");
        sideNavigationBlock.clickOnMyProfile();
        return new MyUserProfilePage();
    }
}

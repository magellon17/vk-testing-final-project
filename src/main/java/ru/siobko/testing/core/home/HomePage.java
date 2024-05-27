package ru.siobko.testing.core.home;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.UIComponent;
import ru.siobko.testing.core.elements.myUserCard.MyUserCardToolBar;
import ru.siobko.testing.core.elements.search.GlobalSearchWrapper;
import ru.siobko.testing.core.elements.sideNavigation.SideNavigationBlock;
import ru.siobko.testing.core.friends.FriendsPagePromise;
import ru.siobko.testing.core.hobbies.HobbiesPagePromise;
import ru.siobko.testing.core.home.elements.avatar.AvatarShortcutMenu;
import ru.siobko.testing.core.home.elements.avatar.PhotoPickerLayer;
import ru.siobko.testing.core.home.elements.publish.PublishingMenuForm;
import ru.siobko.testing.core.media.post.PostWrapper;
import ru.siobko.testing.core.users.myUser.MyUserProfilePagePromise;
import ru.siobko.testing.core.users.user.UserProfilePagePromise;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage implements UIComponent {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    private final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    private static final By FEED_POST = byClassName("feed-w");
    private static final By USER_CARD_TOOLBAR_DROPDOWN = byXpath(".//button[@aria-label='Настройки профиля']");
    private static final By HOBBIES_CONTAINER = byXpath(".//div[@data-l='t,hobbies.content']");
    private static final By UPLOAD_AVATAR_BTN = byText("Добавить фото");
    private static final By AVATAR_BLOCK = byId("hook_Block_Avatar");
    private static final By EXPAND_AVATAR_MENU = byId("viewImageLinkId");
    private static final By PUBLISH_BUTTON = byXpath(".//button[@data-testid='ddm-button']");
    private static final By LAST_CREATED_POST = byId("hook_Block_MainFeedsNewFeed");
    private static final By GLOBAL_SEARCH_CONTAINER = byXpath(".//*[@data-l='t,search']");
    private static final By FRIEND_REQUEST_NOTIFY = byXpath(".//*[@data-l='nA,GROWL_OPEN,t,growl_open']");
    private static final By PUBLISHED_POST_NOTIFY
            = byXpath(".//*[@class='tip __l __active __action-tip __bot __toast __fixed h-mod']");

    public HomePage() {
        check();
        log.info("Загрузилась главная страница пользователя");
    }

    public void check() throws Error {
        $(FEED_POST).shouldBe(
                visible.because("Не отобразился первый пост ленты"));
        $(HOBBIES_CONTAINER).shouldBe(
                visible.because("Не отобразился блок увлечений ленты"));
        $(AVATAR_BLOCK).shouldBe(
                visible.because("Не отобразился блок аватара"));
    }

    public PhotoPickerLayer clikcOnAddAvatar() {
        log.info("Кликаем на 'Добавить фото' в кружочке аватара.");
        $(UPLOAD_AVATAR_BTN).shouldBe(
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

    public boolean isUploadAvatarButtonDisplayed() {
        return $(AVATAR_BLOCK).$(UPLOAD_AVATAR_BTN).isDisplayed();
    }

    public boolean isPublishedPostNotifyDisplayed() {
        return $(PUBLISHED_POST_NOTIFY).shouldBe(visible).isDisplayed();
    }

    public boolean isFriendRequestDisplayed() {
        return $(FRIEND_REQUEST_NOTIFY).shouldBe(visible).isDisplayed();
    }

    public MyUserProfilePagePromise goToProfilePage() {
        log.info("Переходим на страницу профиля");
        sideNavigationBlock.clickOnMyProfile();
        return new MyUserProfilePagePromise();
    }

    public FriendsPagePromise goToFriendsPage() {
        log.info("Переходим на страницу друзей");
        sideNavigationBlock.clickOnFriends();
        return new FriendsPagePromise();
    }

    public HobbiesPagePromise goToHobbiesPage() {
        log.info("Переходим на страницу увлечений");
        sideNavigationBlock.clickOnHobbies();
        return new HobbiesPagePromise();
    }

    public PublishingMenuForm clickPublish() {
        log.info("Кликаем на кнопку 'Опубликовать'.");
        $(PUBLISH_BUTTON).shouldBe(
                visible.because("Нет кнопки 'Опубликовать'.")
        ).click();
        return new PublishingMenuForm();
    }

    public PostWrapper moveToCreatedPost() {
        log.info("Находим последний созданный пост");
        return new PostWrapper($(LAST_CREATED_POST));
    }

    public GlobalSearchWrapper expandGlobalSearch() {
        log.info("Раскрываем поисковик по сайту");
        $(GLOBAL_SEARCH_CONTAINER).shouldBe(
                visible.because("Не отобразился поисковик по сайту")
        ).click();
        return new GlobalSearchWrapper();
    }

    public MyUserCardToolBar expandUserCardToolbar() {
        log.info("Открываем карточку пользователя");
        $(USER_CARD_TOOLBAR_DROPDOWN).shouldBe(
                visible.because("Нет карточки пользователя на странице.")
        ).click();
        return new MyUserCardToolBar();
    }
}

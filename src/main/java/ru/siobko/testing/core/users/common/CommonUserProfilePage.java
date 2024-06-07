package ru.siobko.testing.core.users.common;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siobko.testing.core.elements.sideNavigation.SideNavigationBlock;
import ru.siobko.testing.core.home.HomePagePromise;
import ru.siobko.testing.core.media.photo.PhotoLayer;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public abstract class CommonUserProfilePage {

    private static final Logger log = LoggerFactory.getLogger(CommonUserProfilePage.class);

    protected final SideNavigationBlock sideNavigationBlock = new SideNavigationBlock();

    protected static final By OPEN_LATEST_USER_PHOTO = byXpath(".//*[@data-l='targetPosition,0']");

    public PhotoLayer openLatestPhoto() {
        log.info("Открываем последнее фото профиля");
        $(OPEN_LATEST_USER_PHOTO).shouldBe(
                visible.because("Не отобразилась кнопка настроек")
        ).click();
        return new PhotoLayer();
    }

    public HomePagePromise openHomePage() {
        log.info("Переходим на главную страницу пользователя");
        sideNavigationBlock.clickOnHome();
        return new HomePagePromise();
    }
}
